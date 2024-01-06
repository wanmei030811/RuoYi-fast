package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.CField;
import com.ruoyi.project.customize.domain.CTable;
import com.ruoyi.project.customize.domain.CTableField;
import com.ruoyi.project.customize.service.ICFieldService;
import com.ruoyi.project.customize.service.ICTableFieldService;
import com.ruoyi.project.customize.service.ICTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller
 *
 * @author ruoyi
 * @date 2024-01-06
 */
@Controller
@RequestMapping("/customize/table-field")
public class CTableFieldController extends BaseController {
  private final String prefix = "customize/tableField";
  private final ICFieldService cFieldService;
  private final ICTableService cTableService;
  private final ICTableFieldService cTableFieldService;

  public CTableFieldController(ICTableService cTableService, ICTableFieldService cTableFieldService, ICFieldService cFieldService) {
    this.cTableService = cTableService;
    this.cTableFieldService = cTableFieldService;
    this.cFieldService = cFieldService;
  }

  /**
   * TableField 详情
   */
  @GetMapping("/{tableId}")
  public String tableField(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    modelMap.put("table", cTableService.selectById(tableId));
    modelMap.put("tableList", cTableService.selectTableAll());
    modelMap.put("fieldList", cFieldService.selectCFieldList(new CField()));
    return "customize/tableField/tableField";
  }

  /**
   * 查询列表
   */
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(CTableField cTableField) {
    startPage();
    List<CTableField> list = cTableFieldService.selectCTableFieldList(cTableField);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(CTableField cTableField) {
    List<CTableField> list = cTableFieldService.selectCTableFieldList(cTableField);
    ExcelUtil<CTableField> util = new ExcelUtil<CTableField>(CTableField.class);
    return util.exportExcel(list, "数据");
  }

  /**
   * 新增
   */
  @GetMapping("/add/{tableId}")
  public String add(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    CTable table = cTableService.selectById(tableId);
    modelMap.put("table", table);
    List<CField> fieldList =  cFieldService.selectCFieldList(new CField());
    modelMap.put("fieldList", fieldList);
    return "customize/tableField/add";
  }

  /**
   * 新增保存
   */
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(CTableField cTableField) {
    return toAjax(cTableFieldService.insertCTableField(cTableField));
  }

  /**
   * 修改
   */
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    CTableField cTableField = cTableFieldService.selectCTableFieldByTableId(tableId);
    modelMap.put("cTableField", cTableField);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(CTableField cTableField) {
    return toAjax(cTableFieldService.updateCTableField(cTableField));
  }

  /**
   * 删除
   */
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(cTableFieldService.deleteCTableFieldByTableIds(ids));
  }
}