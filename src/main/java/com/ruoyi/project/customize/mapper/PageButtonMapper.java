package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageButton;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageButtonMapper {
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
   * 删除【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageButtonByTableId(Long tableId);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageButtonByTableIds(String[] tableIds);
}