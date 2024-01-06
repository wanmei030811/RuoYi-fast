package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageView;
import com.ruoyi.project.customize.mapper.PageViewMapper;
import com.ruoyi.project.customize.service.IPageViewService;
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
public class PageViewServiceImpl implements IPageViewService {
  @Autowired
  private PageViewMapper pageViewMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageView selectPageViewByTableId(Long tableId) {
    return pageViewMapper.selectPageViewByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageView 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageView> selectPageViewList(PageView pageView) {
    return pageViewMapper.selectPageViewList(pageView);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageView 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageView(PageView pageView) {
    pageView.setCreateTime(DateUtils.getNowDate());
    return pageViewMapper.insertPageView(pageView);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageView 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageView(PageView pageView) {
    pageView.setUpdateTime(DateUtils.getNowDate());
    return pageViewMapper.updatePageView(pageView);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageViewByTableIds(String tableIds) {
    return pageViewMapper.deletePageViewByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageViewByTableId(Long tableId) {
    return pageViewMapper.deletePageViewByTableId(tableId);
  }
}