package com.ruoyi.project.customize.mapper;

import com.ruoyi.project.customize.domain.Page;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public interface PageMapper {
  /**
   * 查询页面
   *
   * @param pageId 页面主键
   * @return 页面
   */
  public Page selectPageByPageId(Long pageId);

  /**
   * 查询页面列表
   *
   * @param page 页面
   * @return 页面集合
   */
  public List<Page> selectPageList(Page page);

  /**
   * 新增页面
   *
   * @param page 页面
   * @return 结果
   */
  public int insertPage(Page page);

  /**
   * 修改页面
   *
   * @param page 页面
   * @return 结果
   */
  public int updatePage(Page page);

  /**
   * 删除页面
   *
   * @param pageId 页面主键
   * @return 结果
   */
  public int deletePageByPageId(Long pageId);

  /**
   * 批量删除页面
   *
   * @param pageIds 需要删除的数据主键集合
   * @return 结果
   */
  public int deletePageByPageIds(String[] pageIds);
}