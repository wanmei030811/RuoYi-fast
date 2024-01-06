package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.Page;
import com.ruoyi.project.customize.mapper.PageMapper;
import com.ruoyi.project.customize.service.IPageService;
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
public class PageServiceImpl implements IPageService {

  @Autowired
  private PageMapper pageMapper;

  /**
   * 查询页面
   *
   * @param pageId 页面主键
   * @return 页面
   */
  @Override
  public Page selectPageByPageId(Long pageId) {
    return pageMapper.selectPageByPageId(pageId);
  }

  /**
   * 查询页面列表
   *
   * @param page 页面
   * @return 页面
   */
  @Override
  public List<Page> selectPageList(Page page) {
    return pageMapper.selectPageList(page);
  }

  /**
   * 新增页面
   *
   * @param page 页面
   * @return 结果
   */
  @Override
  public int insertPage(Page page) {
    page.setCreateTime(DateUtils.getNowDate());
    return pageMapper.insertPage(page);
  }

  /**
   * 修改页面
   *
   * @param page 页面
   * @return 结果
   */
  @Override
  public int updatePage(Page page) {
    page.setUpdateTime(DateUtils.getNowDate());
    return pageMapper.updatePage(page);
  }

  /**
   * 批量删除页面
   *
   * @param pageIds 需要删除的页面主键
   * @return 结果
   */
  @Override
  public int deletePageByPageIds(String pageIds) {
    return pageMapper.deletePageByPageIds(Convert.toStrArray(pageIds));
  }

  /**
   * 删除页面信息
   *
   * @param pageId 页面主键
   * @return 结果
   */
  @Override
  public int deletePageByPageId(Long pageId) {
    return pageMapper.deletePageByPageId(pageId);
  }
}