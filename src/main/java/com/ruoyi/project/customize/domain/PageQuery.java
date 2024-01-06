package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 页面查询条件对象 page_query
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class PageQuery extends BaseEntity {
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
   * 是否查询字段（1是）
   */
  @Excel(name = "是否查询字段", readConverterExp = "1=是")
  private String isQuery;

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

  public String getIsQuery() {
    return isQuery;
  }

  public void setIsQuery(String isQuery) {
    this.isQuery = isQuery;
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
        .append("isQuery", getIsQuery())
        .append("sort", getSort())
        .append("createBy", getCreateBy())
        .append("createTime", getCreateTime())
        .append("updateBy", getUpdateBy())
        .append("updateTime", getUpdateTime())
        .toString();
  }
}