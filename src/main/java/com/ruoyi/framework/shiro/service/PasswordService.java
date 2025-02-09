package com.ruoyi.framework.shiro.service;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.ShiroConstants;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.common.exception.user.UserPasswordRetryLimitExceedException;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.project.system.user.domain.User;
import jakarta.annotation.PostConstruct;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 登录密码方法
 *
 * @author ruoyi
 */
@Component
public class PasswordService {
  @Autowired
  private CacheManager cacheManager;

  private Cache<String, AtomicInteger> loginRecordCache;

  @Value(value = "${user.password.maxRetryCount}")
  private String maxRetryCount;

  public static void main(String[] args) {
    System.out.println(new PasswordService().encryptPassword("admin", "admin123", "111111"));
    System.out.println(new PasswordService().encryptPassword("ry", "admin123", "222222"));
  }

  @PostConstruct
  public void init() {
    loginRecordCache = cacheManager.getCache(ShiroConstants.LOGINRECORDCACHE);
  }

  public void validate(User user, String password) {
    String loginName = user.getLoginName();

    AtomicInteger retryCount = loginRecordCache.get(loginName);

    if (retryCount == null) {
      retryCount = new AtomicInteger(0);
      loginRecordCache.put(loginName, retryCount);
    }
    if (retryCount.incrementAndGet() > Integer.valueOf(maxRetryCount).intValue()) {
      AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.retry.limit.exceed", maxRetryCount)));
      throw new UserPasswordRetryLimitExceedException(Integer.valueOf(maxRetryCount).intValue());
    }

    if (!matches(user, password)) {
      AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.retry.limit.count", retryCount)));
      loginRecordCache.put(loginName, retryCount);
      throw new UserPasswordNotMatchException();
    } else {
      clearLoginRecordCache(loginName);
    }
  }

  public boolean matches(User user, String newPassword) {
    return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
  }

  public void clearLoginRecordCache(String loginName) {
    loginRecordCache.remove(loginName);
  }

  public String encryptPassword(String loginName, String password, String salt) {
    return new Sha256Hash(loginName + password + salt).toHex();
  }
}