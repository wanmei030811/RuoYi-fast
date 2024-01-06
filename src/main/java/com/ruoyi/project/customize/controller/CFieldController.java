package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.CField;
import com.ruoyi.project.customize.service.ICFieldService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字段Controller
 *
 * @author ruoyi
 * @date 2024-01-06
 */
@Controller
@RequestMapping("/customize/field")
public class CFieldController extends BaseController {
  private final String prefix = "customize/field";

  @Autowired
  private ICFieldService cFieldService;

  @RequiresPermissions("system:field:view")
  @GetMapping()
  public String field() {
    return prefix + "/field";
  }

  /**
   * 查询字段列表
   */
  @RequiresPermissions("system:field:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(CField cField) {
    startPage();
    List<CField> list = cFieldService.selectCFieldList(cField);
    return getDataTable(list);
  }

  /**
   * 导出字段列表
   */
  @RequiresPermissions("system:field:export")
  @Log(title = "字段", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(CField cField) {
    List<CField> list = cFieldService.selectCFieldList(cField);
    ExcelUtil<CField> util = new ExcelUtil<CField>(CField.class);
    return util.exportExcel(list, "字段数据");
  }

  /**
   * 新增字段
   */
  @GetMapping("/add")
  public String add() {
    return prefix + "/add";
  }

  /**
   * 新增保存字段
   */
  @RequiresPermissions("system:field:add")
  @Log(title = "字段", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(CField cField) {
    return toAjax(cFieldService.insertCField(cField));
  }

  /**
   * 修改字段
   */
  @RequiresPermissions("system:field:edit")
  @GetMapping("/edit/{fieldId}")
  public String edit(@PathVariable("fieldId") Integer fieldId, ModelMap modelMap) {
    CField cField = cFieldService.selectCFieldByFieldId(fieldId);
    modelMap.put("cField", cField);
    return prefix + "/edit";
  }

  /**
   * 修改保存字段
   */
  @RequiresPermissions("system:field:edit")
  @Log(title = "字段", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(CField cField) {
    return toAjax(cFieldService.updateCField(cField));
  }

  /**
   * 删除字段
   */
  @RequiresPermissions("system:field:remove")
  @Log(title = "字段", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(cFieldService.deleteCFieldByFieldIds(ids));
  }
}