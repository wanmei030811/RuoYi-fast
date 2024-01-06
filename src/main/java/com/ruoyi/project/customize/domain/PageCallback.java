package com.ruoyi.project.customize.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serial;
import java.io.Serializable;

/**
 * 【请填写功能名称】对象 page_callback
 */
public class PageCallback implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * table主键
   */
  private Long tableId;

  /**
   * 回调地址
   */
  @Excel(name = "回调地址")
  private String url;

  /**
   * 回调方法
   */
  @Excel(name = "回调方法")
  private String function;

  /**
   * 回调参数
   */
  @Excel(name = "回调参数")
  private String params;

  /**
   * 新增A 修改E 删除D
   */
  @Excel(name = "新增A 修改E 删除D ")
  private String type;

  public Long getTableId() {
    return tableId;
  }

  public void setTableId(Long tableId) {
    this.tableId = tableId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }

  public String getParams() {
    return this.params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("tableId", getTableId())
        .append("url", getUrl())
        .append("function", getFunction())
        .append("params", getParams())
        .append("type", getType())
        .toString();
  }
}