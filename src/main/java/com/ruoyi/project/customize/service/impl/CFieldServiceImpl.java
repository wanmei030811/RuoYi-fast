package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.CField;
import com.ruoyi.project.customize.mapper.CFieldMapper;
import com.ruoyi.project.customize.service.ICFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字段Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-06
 */
@Service
public class CFieldServiceImpl implements ICFieldService {
  @Autowired
  private CFieldMapper cFieldMapper;

  /**
   * 查询字段
   *
   * @param fieldId 字段主键
   * @return 字段
   */
  @Override
  public CField selectCFieldByFieldId(Integer fieldId) {
    return cFieldMapper.selectCFieldByFieldId(fieldId);
  }

  /**
   * 查询字段列表
   *
   * @param cField 字段
   * @return 字段
   */
  @Override
  public List<CField> selectCFieldList(CField cField) {
    return cFieldMapper.selectCFieldList(cField);
  }

  /**
   * 新增字段
   *
   * @param cField 字段
   * @return 结果
   */
  @Override
  public int insertCField(CField cField) {
    return cFieldMapper.insertCField(cField);
  }

  /**
   * 修改字段
   *
   * @param cField 字段
   * @return 结果
   */
  @Override
  public int updateCField(CField cField) {
    return cFieldMapper.updateCField(cField);
  }

  /**
   * 批量删除字段
   *
   * @param fieldIds 需要删除的字段主键
   * @return 结果
   */
  @Override
  public int deleteCFieldByFieldIds(String fieldIds) {
    return cFieldMapper.deleteCFieldByFieldIds(Convert.toStrArray(fieldIds));
  }

  /**
   * 删除字段信息
   *
   * @param fieldId 字段主键
   * @return 结果
   */
  @Override
  public int deleteCFieldByFieldId(Integer fieldId) {
    return cFieldMapper.deleteCFieldByFieldId(fieldId);
  }
}