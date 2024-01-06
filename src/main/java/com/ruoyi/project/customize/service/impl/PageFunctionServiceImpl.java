package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageFunction;
import com.ruoyi.project.customize.mapper.PageFunctionMapper;
import com.ruoyi.project.customize.service.IPageFunctionService;
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
public class PageFunctionServiceImpl implements IPageFunctionService {
  @Autowired
  private PageFunctionMapper pageFunctionMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageFunction selectPageFunctionByTableId(Long tableId) {
    return pageFunctionMapper.selectPageFunctionByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageFunction 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageFunction> selectPageFunctionList(PageFunction pageFunction) {
    return pageFunctionMapper.selectPageFunctionList(pageFunction);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageFunction 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageFunction(PageFunction pageFunction) {
    pageFunction.setCreateTime(DateUtils.getNowDate());
    return pageFunctionMapper.insertPageFunction(pageFunction);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageFunction 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageFunction(PageFunction pageFunction) {
    pageFunction.setUpdateTime(DateUtils.getNowDate());
    return pageFunctionMapper.updatePageFunction(pageFunction);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageFunctionByTableIds(String tableIds) {
    return pageFunctionMapper.deletePageFunctionByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageFunctionByTableId(Long tableId) {
    return pageFunctionMapper.deletePageFunctionByTableId(tableId);
  }
}