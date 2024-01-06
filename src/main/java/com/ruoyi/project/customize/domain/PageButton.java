package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 【请填写功能名称】对象 page_button
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class PageButton extends BaseEntity {
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
   * Java字段名称
   */
  @Excel(name = "Java字段名称")
  private String javaField;

  /**
   * DB字段名称
   */
  @Excel(name = "DB字段名称")
  private String dbField;

  /**
   * 按钮作用域（查询区域query、表格区域table、数据行区域datarow）
   */
  @Excel(name = "按钮作用域", readConverterExp = "查=询区域query、表格区域table、数据行区域datarow")
  private String buttonScope;

  /**
   * 按钮样式
   */
  @Excel(name = "按钮样式")
  private String buttonClass;

  /**
   * 按钮类型（增删改查印）
   */
  @Excel(name = "按钮类型", readConverterExp = "增=删改查印")
  private String buttonType;

  /**
   * 按钮权限
   */
  @Excel(name = "按钮权限")
  private String buttonAuthority;

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

  public String getJavaField() {
    return javaField;
  }

  public void setJavaField(String javaField) {
    this.javaField = javaField;
  }

  public String getDbField() {
    return dbField;
  }

  public void setDbField(String dbField) {
    this.dbField = dbField;
  }

  public String getButtonScope() {
    return buttonScope;
  }

  public void setButtonScope(String buttonScope) {
    this.buttonScope = buttonScope;
  }

  public String getButtonClass() {
    return buttonClass;
  }

  public void setButtonClass(String buttonClass) {
    this.buttonClass = buttonClass;
  }

  public String getButtonType() {
    return buttonType;
  }

  public void setButtonType(String buttonType) {
    this.buttonType = buttonType;
  }

  public String getButtonAuthority() {
    return buttonAuthority;
  }

  public void setButtonAuthority(String buttonAuthority) {
    this.buttonAuthority = buttonAuthority;
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
        .append("javaField", getJavaField())
        .append("dbField", getDbField())
        .append("buttonScope", getButtonScope())
        .append("buttonClass", getButtonClass())
        .append("buttonType", getButtonType())
        .append("buttonAuthority", getButtonAuthority())
        .append("sort", getSort())
        .append("createBy", getCreateBy())
        .append("createTime", getCreateTime())
        .append("updateBy", getUpdateBy())
        .append("updateTime", getUpdateTime())
        .toString();
  }
}