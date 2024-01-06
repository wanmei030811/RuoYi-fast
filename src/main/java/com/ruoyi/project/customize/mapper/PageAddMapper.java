package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageAdd;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageAddMapper {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageAdd selectPageAddByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageAdd 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageAdd> selectPageAddList(PageAdd pageAdd);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageAdd 【请填写功能名称】
   * @return 结果
   */
  int insertPageAdd(PageAdd pageAdd);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageAdd 【请填写功能名称】
   * @return 结果
   */
  int updatePageAdd(PageAdd pageAdd);

  /**
   * 删除【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageAddByTableId(Long tableId);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageAddByTableIds(String[] tableIds);
}