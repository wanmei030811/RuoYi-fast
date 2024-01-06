package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageQuery;

import java.util.List;

/**
 * 页面查询条件Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageQueryMapper {
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
   * 删除页面查询条件
   *
   * @param tableId 页面查询条件主键
   * @return 结果
   */
  int deletePageQueryByTableId(Long tableId);

  /**
   * 批量删除页面查询条件
   *
   * @param tableIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageQueryByTableIds(String[] tableIds);
}