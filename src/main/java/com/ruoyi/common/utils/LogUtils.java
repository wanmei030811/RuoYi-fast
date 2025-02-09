package com.ruoyi.common.utils;

import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * 处理并记录日志文件
 *
 * @author ruoyi
 */
public class LogUtils {
  public static final Logger ERROR_LOG = LoggerFactory.getLogger("sys-error");
  public static final Logger ACCESS_LOG = LoggerFactory.getLogger("sys-access");

  /**
   * 记录访问日志 [username][jsessionid][ip][accept][UserAgent][url][params][Referer]
   *
   * @param request
   */
  public static void logAccess(HttpServletRequest request) {
    String username = getUsername();
    String jsessionId = request.getRequestedSessionId();
    String ip = IpUtils.getIpAddr(request);
    String accept = request.getHeader("accept");
    String userAgent = request.getHeader("User-Agent");
    String url = request.getRequestURI();
    String params = getParams(request);

    final String s = getBlock(username) +
        getBlock(jsessionId) +
        getBlock(ip) +
        getBlock(accept) +
        getBlock(userAgent) +
        getBlock(url) +
        getBlock(params) +
        getBlock(request.getHeader("Referer"));
    getAccessLog().info(s);
  }

  /**
   * 记录异常错误 格式 [exception]
   *
   * @param message
   * @param e
   */
  public static void logError(String message, Throwable e) {
    String username = getUsername();
    final String s = getBlock("exception") +
        getBlock(username) +
        getBlock(message);
    ERROR_LOG.error(s, e);
  }

  /**
   * 记录页面错误 错误日志记录 [page/eception][username][statusCode][errorMessage][servletName][uri][exceptionName][ip][exception]
   *
   * @param request
   */
  public static void logPageError(HttpServletRequest request) {
    String username = getUsername();

    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    String message = (String) request.getAttribute("javax.servlet.error.message");
    String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
    Throwable t = (Throwable) request.getAttribute("javax.servlet.error.exception");

    if (statusCode == null) {
      statusCode = 0;
    }

    StringBuilder s = new StringBuilder();
    s.append(getBlock(t == null ? "page" : "exception"));
    s.append(getBlock(username));
    s.append(getBlock(statusCode));
    s.append(getBlock(message));
    s.append(getBlock(IpUtils.getIpAddr(request)));

    s.append(getBlock(uri));
    s.append(getBlock(request.getHeader("Referer")));
    StringWriter sw = new StringWriter();

    while (t != null) {
      t.printStackTrace(new PrintWriter(sw));
      t = t.getCause();
    }
    s.append(getBlock(sw.toString()));
    getErrorLog().error(s.toString());

  }

  public static String getBlock(Object msg) {
    if (msg == null) {
      msg = "";
    }
    return "[" + msg + "]";
  }

  protected static String getParams(HttpServletRequest request) {
    Map<String, String[]> params = request.getParameterMap();
    return JSON.toJSONString(params);
  }

  protected static String getUsername() {
    return (String) SecurityUtils.getSubject().getPrincipal();
  }

  public static Logger getAccessLog() {
    return ACCESS_LOG;
  }

  public static Logger getErrorLog() {
    return ERROR_LOG;
  }
}