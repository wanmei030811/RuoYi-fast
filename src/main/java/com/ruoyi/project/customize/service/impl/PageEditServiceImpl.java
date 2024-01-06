package com.ruoyi.project.customize.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.customize.domain.PageEdit;
import com.ruoyi.project.customize.mapper.PageEditMapper;
import com.ruoyi.project.customize.service.IPageEditService;
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
public class PageEditServiceImpl implements IPageEditService {
  @Autowired
  private PageEditMapper pageEditMapper;

  /**
   * 查询【请填写功能名称】
   *
   * @param tableFieldId 【请填写功能名称】主键
   * @return 【请填写功能名称】
   */
  @Override
  public PageEdit selectPageEditByTableFieldId(Long tableFieldId) {
    return pageEditMapper.selectPageEditByTableFieldId(tableFieldId);
  }

  /**
   * 查询【请填写功能名称】列表
   *
   * @param pageEdit 【请填写功能名称】
   * @return 【请填写功能名称】
   */
  @Override
  public List<PageEdit> selectPageEditList(PageEdit pageEdit) {
    return pageEditMapper.selectPageEditList(pageEdit);
  }

  /**
   * 新增【请填写功能名称】
   *
   * @param pageEdit 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int insertPageEdit(PageEdit pageEdit) {
    pageEdit.setCreateTime(DateUtils.getNowDate());
    return pageEditMapper.insertPageEdit(pageEdit);
  }

  /**
   * 修改【请填写功能名称】
   *
   * @param pageEdit 【请填写功能名称】
   * @return 结果
   */
  @Override
  public int updatePageEdit(PageEdit pageEdit) {
    pageEdit.setUpdateTime(DateUtils.getNowDate());
    return pageEditMapper.updatePageEdit(pageEdit);
  }

  /**
   * 批量删除【请填写功能名称】
   *
   * @param tableFieldIds 需要删除的【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageEditByTableFieldIds(String tableFieldIds) {
    return pageEditMapper.deletePageEditByTableFieldIds(Convert.toStrArray(tableFieldIds));
  }

  /**
   * 删除【请填写功能名称】信息
   *
   * @param tableFieldId 【请填写功能名称】主键
   * @return 结果
   */
  @Override
  public int deletePageEditByTableFieldId(Long tableFieldId) {
    return pageEditMapper.deletePageEditByTableFieldId(tableFieldId);
  }
}