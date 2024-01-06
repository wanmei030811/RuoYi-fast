package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.CTable;
import com.ruoyi.project.customize.service.ICTableService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/customize/table")
public class CTableController extends BaseController {
  private final String prefix = "customize/table";

  @Autowired
  private ICTableService cTableService;

  @RequiresPermissions("system:table:view")
  @GetMapping()
  public String table(ModelMap modelMap) {
    modelMap.put("tableList", cTableService.selectTableAll());
    return prefix + "/table";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:table:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(CTable cTable) {
    startPage();
    List<CTable> list = cTableService.selectCTableList(cTable);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:table:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(CTable cTable) {
    List<CTable> list = cTableService.selectCTableList(cTable);
    ExcelUtil<CTable> util = new ExcelUtil<CTable>(CTable.class);
    return util.exportExcel(list, "数据");
  }

  /**
   * 新增
   */
  @GetMapping("/add")
  public String add() {
    return prefix + "/add";
  }

  /**
   * 新增保存
   */
  @RequiresPermissions("system:table:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(CTable cTable) {
    return toAjax(cTableService.insertCTable(cTable));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:table:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    CTable cTable = cTableService.selectById(tableId);
    modelMap.put("cTable", cTable);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:table:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(CTable cTable) {
    return toAjax(cTableService.updateCTable(cTable));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:table:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(cTableService.deleteCTableByTableIds(ids));
  }
}