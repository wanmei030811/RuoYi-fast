package com.ruoyi.project.monitor.online.service;

import com.ruoyi.project.monitor.online.domain.UserOnline;

import java.util.Date;
import java.util.List;

/**
 * 在线用户 服务层
 *
 * @author ruoyi
 */
public interface IUserOnlineService {
  /**
   * 通过会话序号查询信息
   *
   * @param sessionId 会话ID
   * @return 在线用户信息
   */
  UserOnline selectOnlineById(String sessionId);

  /**
   * 通过会话序号删除信息
   *
   * @param sessionId 会话ID
   * @return 在线用户信息
   */
  void deleteOnlineById(String sessionId);

  /**
   * 通过会话序号删除信息
   *
   * @param sessions 会话ID集合
   * @return 在线用户信息
   */
  void batchDeleteOnline(List<String> sessions);

  /**
   * 保存会话信息
   *
   * @param online 会话信息
   */
  void saveOnline(UserOnline online);

  /**
   * 查询会话集合
   *
   * @param userOnline 分页参数
   * @return 会话集合
   */
  List<UserOnline> selectUserOnlineList(UserOnline userOnline);

  /**
   * 强退用户
   *
   * @param sessionId 会话ID
   */
  void forceLogout(String sessionId);

  /**
   * 清理用户缓存
   *
   * @param loginName 登录名称
   * @param sessionId 会话ID
   */
  void removeUserCache(String loginName, String sessionId);

  /**
   * 查询会话集合
   *
   * @param expiredDate 有效期
   * @return 会话集合
   */
  List<UserOnline> selectOnlineByExpired(Date expiredDate);
}