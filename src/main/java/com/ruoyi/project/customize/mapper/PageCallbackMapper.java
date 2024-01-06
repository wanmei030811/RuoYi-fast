package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageCallback;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageCallbackMapper {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageCallback selectPageCallbackByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageCallback 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageCallback> selectPageCallbackList(PageCallback pageCallback);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageCallback 【请填写功能名称】
   * @return 结果
   */
  int insertPageCallback(PageCallback pageCallback);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageCallback 【请填写功能名称】
   * @return 结果
   */
  int updatePageCallback(PageCallback pageCallback);

  /**
   * 删除【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageCallbackByTableId(Long tableId);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageCallbackByTableIds(String[] tableIds);
}