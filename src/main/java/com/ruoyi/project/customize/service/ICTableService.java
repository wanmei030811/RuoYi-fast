package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.CTable;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface ICTableService {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  CTable selectById(Long tableId);


  List<CTable> selectTableAll();

  /**
   * 查询【请填写功能名称】列表
   *
   * @param cTable 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<CTable> selectCTableList(CTable cTable);

  /**
   * 新增【请填写功能名称】
   *
   * @param cTable 【请填写功能名称】
   * @return 结果
   */
  int insertCTable(CTable cTable);

  /**
   * 修改【请填写功能名称】
   *
   * @param cTable 【请填写功能名称】
   * @return 结果
   */
  int updateCTable(CTable cTable);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deleteCTableByTableIds(String tableIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deleteCTableByTableId(Long tableId);
}