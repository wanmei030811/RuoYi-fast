package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.CTableField;
import com.ruoyi.project.customize.mapper.CTableFieldMapper;
import com.ruoyi.project.customize.service.ICTableFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-06
 */
@Service
public class CTableFieldServiceImpl implements ICTableFieldService {
  @Autowired
  private CTableFieldMapper cTableFieldMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public CTableField selectCTableFieldByTableId(Long tableId) {
    return cTableFieldMapper.selectCTableFieldByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param cTableField 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<CTableField> selectCTableFieldList(CTableField cTableField) {
    return cTableFieldMapper.selectCTableFieldList(cTableField);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param cTableField 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertCTableField(CTableField cTableField) {
    cTableField.setCreateTime(DateUtils.getNowDate());
    return cTableFieldMapper.insertCTableField(cTableField);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param cTableField 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updateCTableField(CTableField cTableField) {
    cTableField.setUpdateTime(DateUtils.getNowDate());
    return cTableFieldMapper.updateCTableField(cTableField);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deleteCTableFieldByTableIds(String tableIds) {
    return cTableFieldMapper.deleteCTableFieldByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deleteCTableFieldByTableId(Long tableId) {
    return cTableFieldMapper.deleteCTableFieldByTableId(tableId);
  }
}