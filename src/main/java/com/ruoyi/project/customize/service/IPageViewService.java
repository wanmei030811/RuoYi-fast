package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.PageView;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface IPageViewService {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageView selectPageViewByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageView 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageView> selectPageViewList(PageView pageView);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageView 【请填写功能名称】
   * @return 结果
   */
  int insertPageView(PageView pageView);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageView 【请填写功能名称】
   * @return 结果
   */
  int updatePageView(PageView pageView);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deletePageViewByTableIds(String tableIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageViewByTableId(Long tableId);
}