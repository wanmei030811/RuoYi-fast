package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 【请填写功能名称】对象 c_table_field
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class CTableField extends BaseEntity {
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
   * JAVA类型
   */
  @Excel(name = "JAVA类型")
  private String javaType;

  /**
   * JAVA字段名
   */
  @Excel(name = "JAVA字段名")
  private String javaField;

  /**
   * 是否主键（1是）
   */
  @Excel(name = "是否主键", readConverterExp = "1=是")
  private String isPk;

  /**
   * 是否自增（1是）
   */
  @Excel(name = "是否自增", readConverterExp = "1=是")
  private String isIncrement;

  /**
   * 是否必填（1是）
   */
  @Excel(name = "是否必填", readConverterExp = "1=是")
  private String isRequired;

  /**
   * 是否为插入字段（1是）
   */
  @Excel(name = "是否为插入字段", readConverterExp = "1=是")
  private String isInsert;

  /**
   * 是否编辑字段（1是）
   */
  @Excel(name = "是否编辑字段", readConverterExp = "1=是")
  private String isEdit;

  /**
   * 是否列表字段（1是）
   */
  @Excel(name = "是否列表字段", readConverterExp = "1=是")
  private String isList;

  /**
   * 是否查询字段（1是）
   */
  @Excel(name = "是否查询字段", readConverterExp = "1=是")
  private String isQuery;

  /**
   * 查询方式（等于、不等于、大于、小于、范围）
   */
  @Excel(name = "查询方式", readConverterExp = "等=于、不等于、大于、小于、范围")
  private String queryType;

  /**
   * 显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）
   */
  @Excel(name = "显示类型", readConverterExp = "文=本框、文本域、下拉框、复选框、单选框、日期控件")
  private String htmlType;

  /**
   * 字典类型
   */
  @Excel(name = "字典类型")
  private String dictType;

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

  public String getJavaType() {
    return javaType;
  }

  public void setJavaType(String javaType) {
    this.javaType = javaType;
  }

  public String getJavaField() {
    return javaField;
  }

  public void setJavaField(String javaField) {
    this.javaField = javaField;
  }

  public String getIsPk() {
    return isPk;
  }

  public void setIsPk(String isPk) {
    this.isPk = isPk;
  }

  public String getIsIncrement() {
    return isIncrement;
  }

  public void setIsIncrement(String isIncrement) {
    this.isIncrement = isIncrement;
  }

  public String getIsRequired() {
    return isRequired;
  }

  public void setIsRequired(String isRequired) {
    this.isRequired = isRequired;
  }

  public String getIsInsert() {
    return isInsert;
  }

  public void setIsInsert(String isInsert) {
    this.isInsert = isInsert;
  }

  public String getIsEdit() {
    return isEdit;
  }

  public void setIsEdit(String isEdit) {
    this.isEdit = isEdit;
  }

  public String getIsList() {
    return isList;
  }

  public void setIsList(String isList) {
    this.isList = isList;
  }

  public String getIsQuery() {
    return isQuery;
  }

  public void setIsQuery(String isQuery) {
    this.isQuery = isQuery;
  }

  public String getQueryType() {
    return queryType;
  }

  public void setQueryType(String queryType) {
    this.queryType = queryType;
  }

  public String getHtmlType() {
    return htmlType;
  }

  public void setHtmlType(String htmlType) {
    this.htmlType = htmlType;
  }

  public String getDictType() {
    return dictType;
  }

  public void setDictType(String dictType) {
    this.dictType = dictType;
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
        .append("javaType", getJavaType())
        .append("javaField", getJavaField())
        .append("isPk", getIsPk())
        .append("isIncrement", getIsIncrement())
        .append("isRequired", getIsRequired())
        .append("isInsert", getIsInsert())
        .append("isEdit", getIsEdit())
        .append("isList", getIsList())
        .append("isQuery", getIsQuery())
        .append("queryType", getQueryType())
        .append("htmlType", getHtmlType())
        .append("dictType", getDictType())
        .append("sort", getSort())
        .append("createBy", getCreateBy())
        .append("createTime", getCreateTime())
        .append("updateBy", getUpdateBy())
        .append("updateTime", getUpdateTime())
        .toString();
  }
}