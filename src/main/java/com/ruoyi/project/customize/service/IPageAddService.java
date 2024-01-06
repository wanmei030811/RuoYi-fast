package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.PageAdd;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface IPageAddService {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageAdd selectPageAddByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageAdd 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageAdd> selectPageAddList(PageAdd pageAdd);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageAdd 【请填写功能名称】
   * @return 结果
   */
  int insertPageAdd(PageAdd pageAdd);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageAdd 【请填写功能名称】
   * @return 结果
   */
  int updatePageAdd(PageAdd pageAdd);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deletePageAddByTableIds(String tableIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageAddByTableId(Long tableId);
}