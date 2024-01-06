package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 【请填写功能名称】对象 page_authority
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class PageAuthority extends BaseEntity {
  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * table主键
   */
  private Long tableId;

  /**
   * field主键
   */
  private Long fieldId;

  /**
   * 排序
   */
  @Excel(name = "排序")
  private Long sort;

  public Long getTableId() {
    return tableId;
  }

  public void setTableId(Long tableId) {
    this.tableId = tableId;
  }

  public Long getFieldId() {
    return fieldId;
  }

  public void setFieldId(Long fieldId) {
    this.fieldId = fieldId;
  }

  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("tableId", getTableId())
        .append("fieldId", getFieldId())
        .append("sort", getSort())
        .append("createBy", getCreateBy())
        .append("createTime", getCreateTime())
        .append("updateBy", getUpdateBy())
        .append("updateTime", getUpdateTime())
        .toString();
  }
}