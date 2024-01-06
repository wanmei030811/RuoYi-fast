package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.CTable;
import com.ruoyi.project.customize.mapper.CTableMapper;
import com.ruoyi.project.customize.service.ICTableService;
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
public class CTableServiceImpl implements ICTableService {
  @Autowired
  private CTableMapper cTableMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public CTable selectById(Long tableId) {
    return cTableMapper.selectById(tableId);
  }

  @Override
  public List<CTable> selectTableAll() {
    return cTableMapper.selectTableAll();
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param cTable 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<CTable> selectCTableList(CTable cTable) {
    return cTableMapper.selectCTableList(cTable);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param cTable 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertCTable(CTable cTable) {
    return cTableMapper.insertCTable(cTable);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param cTable 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updateCTable(CTable cTable) {
    return cTableMapper.updateCTable(cTable);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deleteCTableByTableIds(String tableIds) {
    return cTableMapper.deleteCTableByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deleteCTableByTableId(Long tableId) {
    return cTableMapper.deleteCTableByTableId(tableId);
  }
}