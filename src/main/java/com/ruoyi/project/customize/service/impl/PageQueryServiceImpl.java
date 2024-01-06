package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageQuery;
import com.ruoyi.project.customize.mapper.PageQueryMapper;
import com.ruoyi.project.customize.service.IPageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 页面查询条件Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-06
 */
@Service
public class PageQueryServiceImpl implements IPageQueryService {
  @Autowired
  private PageQueryMapper pageQueryMapper;

  /**
   * 查询页面查询条件
   *
   * @param tableId 页面查询条件主键
   * @return 页面查询条件
   */
  @Override
  public PageQuery selectPageQueryByTableId(Long tableId) {
    return pageQueryMapper.selectPageQueryByTableId(tableId);
  }

  /**
   * 查询页面查询条件列表
   *
   * @param pageQuery 页面查询条件
   * @return 页面查询条件
   */
  @Override
  public List<PageQuery> selectPageQueryList(PageQuery pageQuery) {
    return pageQueryMapper.selectPageQueryList(pageQuery);
  }

  /**
   * 新增页面查询条件
   *
   * @param pageQuery 页面查询条件
   * @return 结果
   */
  @Override
  public int insertPageQuery(PageQuery pageQuery) {
    pageQuery.setCreateTime(DateUtils.getNowDate());
    return pageQueryMapper.insertPageQuery(pageQuery);
  }

  /**
   * 修改页面查询条件
   *
   * @param pageQuery 页面查询条件
   * @return 结果
   */
  @Override
  public int updatePageQuery(PageQuery pageQuery) {
    pageQuery.setUpdateTime(DateUtils.getNowDate());
    return pageQueryMapper.updatePageQuery(pageQuery);
  }

  /**
   * 批量删除页面查询条件
   *
   * @param tableIds 需要删除的页面查询条件主键
   * @return 结果
   */
  @Override
  public int deletePageQueryByTableIds(String tableIds) {
    return pageQueryMapper.deletePageQueryByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除页面查询条件信息
   *
   * @param tableId 页面查询条件主键
   * @return 结果
   */
  @Override
  public int deletePageQueryByTableId(Long tableId) {
    return pageQueryMapper.deletePageQueryByTableId(tableId);
  }
}