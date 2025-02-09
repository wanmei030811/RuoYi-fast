package com.ruoyi.framework.shiro.session;

import com.ruoyi.common.utils.IpUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.monitor.online.domain.OnlineSession;
import com.ruoyi.project.monitor.online.domain.UserOnline;
import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.springframework.stereotype.Component;

/**
 * 自定义sessionFactory会话
 *
 * @author ruoyi
 */
@Component
public class OnlineSessionFactory implements SessionFactory {
  public Session createSession(UserOnline userOnline) {
    OnlineSession onlineSession = userOnline.getSession();
    if (StringUtils.isNotNull(onlineSession) && onlineSession.getId() == null) {
      onlineSession.setId(userOnline.getSessionId());
    }
    return userOnline.getSession();
  }

  @Override
  public Session createSession(SessionContext initData) {
    OnlineSession session = new OnlineSession();
    if (initData != null && initData instanceof final WebSessionContext sessionContext) {
      HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
      if (request != null) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        // 获取客户端操作系统
        String os = userAgent.getOperatingSystem().getName();
        // 获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        session.setHost(IpUtils.getIpAddr(request));
        session.setBrowser(browser);
        session.setOs(os);
      }
    }
    return session;
  }
}