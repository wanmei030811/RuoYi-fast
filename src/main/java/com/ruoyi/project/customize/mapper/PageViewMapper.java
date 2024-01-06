package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageView;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageViewMapper {
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
   * 删除【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageViewByTableId(Long tableId);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageViewByTableIds(String[] tableIds);
}