package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.PageButton;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface IPageButtonService {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageButton selectPageButtonByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageButton 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageButton> selectPageButtonList(PageButton pageButton);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageButton 【请填写功能名称】
   * @return 结果
   */
  int insertPageButton(PageButton pageButton);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageButton 【请填写功能名称】
   * @return 结果
   */
  int updatePageButton(PageButton pageButton);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deletePageButtonByTableIds(String tableIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageButtonByTableId(Long tableId);
}