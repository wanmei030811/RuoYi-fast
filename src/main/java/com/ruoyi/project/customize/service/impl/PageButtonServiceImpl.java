package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageButton;
import com.ruoyi.project.customize.mapper.PageButtonMapper;
import com.ruoyi.project.customize.service.IPageButtonService;
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
public class PageButtonServiceImpl implements IPageButtonService {
  @Autowired
  private PageButtonMapper pageButtonMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageButton selectPageButtonByTableId(Long tableId) {
    return pageButtonMapper.selectPageButtonByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageButton 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageButton> selectPageButtonList(PageButton pageButton) {
    return pageButtonMapper.selectPageButtonList(pageButton);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageButton 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageButton(PageButton pageButton) {
    pageButton.setCreateTime(DateUtils.getNowDate());
    return pageButtonMapper.insertPageButton(pageButton);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageButton 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageButton(PageButton pageButton) {
    pageButton.setUpdateTime(DateUtils.getNowDate());
    return pageButtonMapper.updatePageButton(pageButton);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageButtonByTableIds(String tableIds) {
    return pageButtonMapper.deletePageButtonByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageButtonByTableId(Long tableId) {
    return pageButtonMapper.deletePageButtonByTableId(tableId);
  }
}