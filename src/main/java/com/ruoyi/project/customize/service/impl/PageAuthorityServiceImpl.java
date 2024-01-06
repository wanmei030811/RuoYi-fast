package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageAuthority;
import com.ruoyi.project.customize.mapper.PageAuthorityMapper;
import com.ruoyi.project.customize.service.IPageAuthorityService;
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
public class PageAuthorityServiceImpl implements IPageAuthorityService {
  @Autowired
  private PageAuthorityMapper pageAuthorityMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageAuthority selectPageAuthorityByTableId(Long tableId) {
    return pageAuthorityMapper.selectPageAuthorityByTableId(tableId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageAuthority 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageAuthority> selectPageAuthorityList(PageAuthority pageAuthority) {
    return pageAuthorityMapper.selectPageAuthorityList(pageAuthority);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageAuthority 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageAuthority(PageAuthority pageAuthority) {
    pageAuthority.setCreateTime(DateUtils.getNowDate());
    return pageAuthorityMapper.insertPageAuthority(pageAuthority);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageAuthority 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageAuthority(PageAuthority pageAuthority) {
    pageAuthority.setUpdateTime(DateUtils.getNowDate());
    return pageAuthorityMapper.updatePageAuthority(pageAuthority);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageAuthorityByTableIds(String tableIds) {
    return pageAuthorityMapper.deletePageAuthorityByTableIds(Convert.toStrArray(tableIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageAuthorityByTableId(Long tableId) {
    return pageAuthorityMapper.deletePageAuthorityByTableId(tableId);
  }
}