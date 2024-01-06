package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 字段对象 c_field
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class CField extends BaseEntity {
  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * 字段主键
   */
  private Integer fieldId;

  /**
   * 字段名称
   */
  @Excel(name = "字段名称")
  private String fieldName;

  /**
   * 字段描述
   */
  @Excel(name = "字段描述")
  private String fieldComment;

  /**
   * 字段类型
   */
  @Excel(name = "字段类型")
  private String fieldType;

  /**
   * 字段状态（0正常 1停用）
   */
  @Excel(name = "字段状态", readConverterExp = "0=正常,1=停用")
  private String fieldStatus;

  public Integer getFieldId() {
    return fieldId;
  }

  public void setFieldId(Integer fieldId) {
    this.fieldId = fieldId;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFieldComment() {
    return fieldComment;
  }

  public void setFieldComment(String fieldComment) {
    this.fieldComment = fieldComment;
  }

  public String getFieldType() {
    return fieldType;
  }

  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
  }

  public String getFieldStatus() {
    return fieldStatus;
  }

  public void setFieldStatus(String fieldStatus) {
    this.fieldStatus = fieldStatus;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("fieldId", getFieldId())
        .append("fieldName", getFieldName())
        .append("fieldComment", getFieldComment())
        .append("fieldType", getFieldType())
        .append("fieldStatus", getFieldStatus())
        .toString();
  }
}