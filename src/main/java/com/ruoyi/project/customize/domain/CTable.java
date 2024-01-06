package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;

/**
 * 【请填写功能名称】对象 c_table
 *
 * @author ruoyi
 * @date 2024-01-06
 */
public class CTable extends BaseEntity {
  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * table主键
   */
  private Long tableId;

  /**
   * 父table主键
   */
  @Excel(name = "父table主键")
  private String parentTableId;

  /**
   * table名称
   */
  @Excel(name = "table名称")
  private String tableName;

  /**
   * table描述
   */
  @Excel(name = "table描述")
  private String tableComment;

  /**
   * table类型
   */
  @Excel(name = "table类型")
  private String tableType;

  /**
   * table状态（0正常 1停用）
   */
  @Excel(name = "table状态", readConverterExp = "0=正常,1=停用")
  private String tableStatus;

  public Long getTableId() {
    return tableId;
  }

  public void setTableId(Long tableId) {
    this.tableId = tableId;
  }

  public String getParentTableId() {
    return parentTableId;
  }

  public void setParentTableId(String parentTableId) {
    this.parentTableId = parentTableId;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getTableComment() {
    return tableComment;
  }

  public void setTableComment(String tableComment) {
    this.tableComment = tableComment;
  }

  public String getTableType() {
    return tableType;
  }

  public void setTableType(String tableType) {
    this.tableType = tableType;
  }

  public String getTableStatus() {
    return tableStatus;
  }

  public void setTableStatus(String tableStatus) {
    this.tableStatus = tableStatus;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("tableId", getTableId())
        .append("parentTableId", getParentTableId())
        .append("tableName", getTableName())
        .append("tableComment", getTableComment())
        .append("tableType", getTableType())
        .append("tableStatus", getTableStatus())
        .toString();
  }
}