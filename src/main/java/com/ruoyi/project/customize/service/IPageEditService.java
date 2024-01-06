package com.ruoyi.project.customize.service;

import com.ruoyi.project.customize.domain.PageEdit;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface IPageEditService {
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
   * 批量删除【请填写功能名称】
   *
   * @param tableFieldIds 需要删除的【请填写功能名称】主键集合
   * @return 结果
   */
  int deletePageEditByTableFieldIds(String tableFieldIds);

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableFieldId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageEditByTableFieldId(Long tableFieldId);
}