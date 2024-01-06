package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 【请填写功能名称】对象 page
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class Page extends BaseEntity {
  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * 页面主键
   */
  private Long pageId;

  /**
   * 页面名称
   */
  @Excel(name = "页面名称")
  private String pageName;

  /**
   * 页面类型
   */
  @Excel(name = "页面类型")
  private String pageType;

  /**
   * 排序
   */
  @Excel(name = "排序")
  private Long sort;

  /**
   * 删除标志（0代表存在 1代表删除）
   */
  private String delFlag;

  public Long getPageId() {
    return pageId;
  }

  public void setPageId(Long pageId) {
    this.pageId = pageId;
  }

  public String getPageName() {
    return pageName;
  }

  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  public String getPageType() {
    return pageType;
  }

  public void setPageType(String pageType) {
    this.pageType = pageType;
  }

  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

  public String getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(String delFlag) {
    this.delFlag = delFlag;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("pageId", getPageId())
        .append("pageName", getPageName())
        .append("pageType", getPageType())
        .append("sort", getSort())
        .append("delFlag", getDelFlag())
        .append("createBy", getCreateBy())
        .append("createTime", getCreateTime())
        .append("updateBy", getUpdateBy())
        .append("updateTime", getUpdateTime())
        .toString();
  }
}