package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.PageAuthority;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageAuthorityMapper {
  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  PageAuthority selectPageAuthorityByTableId(Long tableId);

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageAuthority 【请填写功能名称】
   * @return 【请填写功能名称】集合
   */
  List<PageAuthority> selectPageAuthorityList(PageAuthority pageAuthority);

  /**
   * 新增【请填写功能名称】
   *
   * @param pageAuthority 【请填写功能名称】
   * @return 结果
   */
  int insertPageAuthority(PageAuthority pageAuthority);

  /**
   * 修改【请填写功能名称】
   *
   * @param pageAuthority 【请填写功能名称】
   * @return 结果
   */
  int updatePageAuthority(PageAuthority pageAuthority);

  /**
   * 删除【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  int deletePageAuthorityByTableId(Long tableId);

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的数据主键集合
   * @return 结果
   */
  int deletePageAuthorityByTableIds(String[] tableIds);
}