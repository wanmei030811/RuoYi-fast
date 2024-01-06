package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageEdit;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageEditMapper {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableFieldId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageEdit selectPageEditByTableFieldId(Long tableFieldId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageEdit 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageEdit> selectPageEditList(PageEdit pageEdit);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageEdit 【请填写功能名称】
   * @return 结果
   */
  int insertPageEdit(PageEdit pageEdit);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageEdit 【请填写功能名称】
   * @return 结果
   */
  int updatePageEdit(PageEdit pageEdit);

  /**
   * 删除【请填写功能名称】
   *
   * @param tableFieldId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageEditByTableFieldId(Long tableFieldId);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableFieldIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageEditByTableFieldIds(String[] tableFieldIds);
}