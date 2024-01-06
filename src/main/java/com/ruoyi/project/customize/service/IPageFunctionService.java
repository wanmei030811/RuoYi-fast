package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.PageFunction;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface IPageFunctionService {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageFunction selectPageFunctionByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageFunction 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageFunction> selectPageFunctionList(PageFunction pageFunction);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageFunction 【请填写功能名称】
   * @return 结果
   */
  int insertPageFunction(PageFunction pageFunction);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageFunction 【请填写功能名称】
   * @return 结果
   */
  int updatePageFunction(PageFunction pageFunction);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deletePageFunctionByTableIds(String tableIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageFunctionByTableId(Long tableId);
}