package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.PageList;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface IPageListService {
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
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deletePageListByTableIds(String tableIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageListByTableId(Long tableId);
}