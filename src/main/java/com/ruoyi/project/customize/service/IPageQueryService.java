package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.PageQuery;

import java.util.List;

/**
 * 页面查询条件Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface IPageQueryService {
  /**
   * 查询页面查询条件
   *
   * @param tableId 页面查询条件主键
   * @return 页面查询条件
   */
  PageQuery selectPageQueryByTableId(Long tableId);

  /**
   * 查询页面查询条件列表
   *
   * @param pageQuery 页面查询条件
   * @return 页面查询条件集合
   */
  List<PageQuery> selectPageQueryList(PageQuery pageQuery);

  /**
   * 新增页面查询条件
   *
   * @param pageQuery 页面查询条件
   * @return 结果
   */
  int insertPageQuery(PageQuery pageQuery);

  /**
   * 修改页面查询条件
   *
   * @param pageQuery 页面查询条件
   * @return 结果
   */
  int updatePageQuery(PageQuery pageQuery);

  /**
   * 批量删除页面查询条件
   *
   * @param tableIds 需要删除的页面查询条件主键集合
   * @return 结果
   */
  int deletePageQueryByTableIds(String tableIds);

  /**
   * 删除页面查询条件信息
   *
   * @param tableId 页面查询条件主键
   * @return 结果
   */
  int deletePageQueryByTableId(Long tableId);
}