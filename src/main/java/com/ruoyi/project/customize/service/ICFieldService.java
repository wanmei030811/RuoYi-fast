package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.CField;

import java.util.List;

/**
 * 字段Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface ICFieldService {
  /**
   * 查询字段
   *
   * @param fieldId 字段主键
   * @return 字段
   */
  CField selectCFieldByFieldId(Integer fieldId);

  /**
   * 查询字段列表
   *
   * @param cField 字段
   * @return 字段集合
   */
  List<CField> selectCFieldList(CField cField);

  /**
   * 新增字段
   *
   * @param cField 字段
   * @return 结果
   */
  int insertCField(CField cField);

  /**
   * 修改字段
   *
   * @param cField 字段
   * @return 结果
   */
  int updateCField(CField cField);

  /**
   * 批量删除字段
   *
   * @param fieldIds 需要删除的字段主键集合
   * @return 结果
   */
  int deleteCFieldByFieldIds(String fieldIds);

  /**
   * 删除字段信息
   *
   * @param fieldId 字段主键
   * @return 结果
   */
  int deleteCFieldByFieldId(Integer fieldId);
}