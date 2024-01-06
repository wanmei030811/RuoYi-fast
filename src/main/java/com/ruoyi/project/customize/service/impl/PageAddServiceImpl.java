package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageAdd;
import com.ruoyi.project.customize.mapper.PageAddMapper;
import com.ruoyi.project.customize.service.IPageAddService;
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
public class PageAddServiceImpl implements IPageAddService {
  @Autowired
  private PageAddMapper pageAddMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageAdd selectPageAddByTableId(Long tableId) {
    return pageAddMapper.selectPageAddByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageAdd 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageAdd> selectPageAddList(PageAdd pageAdd) {
    return pageAddMapper.selectPageAddList(pageAdd);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageAdd 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageAdd(PageAdd pageAdd) {
    pageAdd.setCreateTime(DateUtils.getNowDate());
    return pageAddMapper.insertPageAdd(pageAdd);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageAdd 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageAdd(PageAdd pageAdd) {
    pageAdd.setUpdateTime(DateUtils.getNowDate());
    return pageAddMapper.updatePageAdd(pageAdd);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageAddByTableIds(String tableIds) {
    return pageAddMapper.deletePageAddByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageAddByTableId(Long tableId) {
    return pageAddMapper.deletePageAddByTableId(tableId);
  }
}