package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageCallback;
import com.ruoyi.project.customize.mapper.PageCallbackMapper;
import com.ruoyi.project.customize.service.IPageCallbackService;
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
public class PageCallbackServiceImpl implements IPageCallbackService {
  @Autowired
  private PageCallbackMapper pageCallbackMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageCallback selectPageCallbackByTableId(Long tableId) {
    return pageCallbackMapper.selectPageCallbackByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageCallback 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageCallback> selectPageCallbackList(PageCallback pageCallback) {
    return pageCallbackMapper.selectPageCallbackList(pageCallback);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageCallback 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageCallback(PageCallback pageCallback) {
    return pageCallbackMapper.insertPageCallback(pageCallback);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageCallback 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageCallback(PageCallback pageCallback) {
    return pageCallbackMapper.updatePageCallback(pageCallback);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageCallbackByTableIds(String tableIds) {
    return pageCallbackMapper.deletePageCallbackByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageCallbackByTableId(Long tableId) {
    return pageCallbackMapper.deletePageCallbackByTableId(tableId);
  }
}