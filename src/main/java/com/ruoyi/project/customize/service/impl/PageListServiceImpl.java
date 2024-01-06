package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageList;
import com.ruoyi.project.customize.mapper.PageListMapper;
import com.ruoyi.project.customize.service.IPageListService;
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
public class PageListServiceImpl implements IPageListService {
  @Autowired
  private PageListMapper pageListMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageList selectPageListByTableId(Long tableId) {
    return pageListMapper.selectPageListByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageList 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageList> selectPageListList(PageList pageList) {
    return pageListMapper.selectPageListList(pageList);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageList 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageList(PageList pageList) {
    pageList.setCreateTime(DateUtils.getNowDate());
    return pageListMapper.insertPageList(pageList);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageList 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageList(PageList pageList) {
    pageList.setUpdateTime(DateUtils.getNowDate());
    return pageListMapper.updatePageList(pageList);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageListByTableIds(String tableIds) {
    return pageListMapper.deletePageListByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageListByTableId(Long tableId) {
    return pageListMapper.deletePageListByTableId(tableId);
  }
}