package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.CTableField;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface ICTableFieldService {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  CTableField selectCTableFieldByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param cTableField 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<CTableField> selectCTableFieldList(CTableField cTableField);

  /**
   * 新增【请填写功能名称】
   *
   * @param cTableField 【请填写功能名称】
   * @return 结果
   */
  int insertCTableField(CTableField cTableField);

  /**
   * 修改【请填写功能名称】
   *
   * @param cTableField 【请填写功能名称】
   * @return 结果
   */
  int updateCTableField(CTableField cTableField);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deleteCTableFieldByTableIds(String tableIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deleteCTableFieldByTableId(Long tableId);
}