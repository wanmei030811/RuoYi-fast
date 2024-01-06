package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 【请填写功能名称】对象 page_add
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class PageAdd extends BaseEntity {
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
   * 是否必填（1是）
   */
  @Excel(name = "是否必填", readConverterExp = "1=是")
  private String isRequired;

  /**
   * 默认值
   */
  @Excel(name = "默认值")
  private String dValue;

  /**
   * 默认值类型
   */
  @Excel(name = "默认值类型")
  private String dVType;

  /**
   * 默认值来源
   */
  @Excel(name = "默认值来源")
  private String dVSource;

  /**
   * 默认后是否可编辑（1是）
   */
  @Excel(name = "默认后是否可编辑", readConverterExp = "1=是")
  private String dVEdit;

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

  public String getIsRequired() {
    return isRequired;
  }

  public void setIsRequired(String isRequired) {
    this.isRequired = isRequired;
  }

  public String getdValue() {
    return dValue;
  }

  public void setdValue(String dValue) {
    this.dValue = dValue;
  }

  public String getdVType() {
    return dVType;
  }

  public void setdVType(String dVType) {
    this.dVType = dVType;
  }

  public String getdVSource() {
    return dVSource;
  }

  public void setdVSource(String dVSource) {
    this.dVSource = dVSource;
  }

  public String getdVEdit() {
    return dVEdit;
  }

  public void setdVEdit(String dVEdit) {
    this.dVEdit = dVEdit;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("tableId", getTableId())
        .append("fieldId", getFieldId())
        .append("isRequired", getIsRequired())
        .append("dValue", getdValue())
        .append("dVType", getdVType())
        .append("dVSource", getdVSource())
        .append("dVEdit", getdVEdit())
        .append("createBy", getCreateBy())
        .append("createTime", getCreateTime())
        .append("updateBy", getUpdateBy())
        .append("updateTime", getUpdateTime())
        .toString();
  }
}