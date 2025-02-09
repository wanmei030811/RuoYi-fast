package com.ruoyi.common.utils.security;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.system.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * shiro 工具类
 *
 * @author ruoyi
 */
public class ShiroUtils {
  public static Subject getSubject() {
    return SecurityUtils.getSubject();
  }

  public static Session getSession() {
    return SecurityUtils.getSubject().getSession();
  }

  public static void logout() {
    getSubject().logout();
  }

  public static User getSysUser() {
    User user = null;
    Object obj = getSubject().getPrincipal();
    if (StringUtils.isNotNull(obj)) {
      user = new User();
      BeanUtils.copyBeanProp(user, obj);
    }
    return user;
  }

  public static void setSysUser(User user) {
    Subject subject = getSubject();
    PrincipalCollection principalCollection = subject.getPrincipals();
    String realmName = principalCollection.getRealmNames().iterator().next();
    PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
    // 重新加载Principal
    subject.runAs(newPrincipalCollection);
  }

  public static Long getUserId() {
    return getSysUser().getUserId().longValue();
  }

  public static String getLoginName() {
    return getSysUser().getLoginName();
  }

  public static String getIp() {
    return StringUtils.substring(getSubject().getSession().getHost(), 0, 128);
  }

  public static String getSessionId() {
    return String.valueOf(getSubject().getSession().getId());
  }
}