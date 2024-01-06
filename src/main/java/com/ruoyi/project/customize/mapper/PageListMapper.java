package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageList;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageListMapper {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageList selectPageListByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageList 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageList> selectPageListList(PageList pageList);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageList 【请填写功能名称】
   * @return 结果
   */
  int insertPageList(PageList pageList);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageList 【请填写功能名称】
   * @return 结果
   */
  int updatePageList(PageList pageList);

  /**
   * 删除【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageListByTableId(Long tableId);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageListByTableIds(String[] tableIds);
}