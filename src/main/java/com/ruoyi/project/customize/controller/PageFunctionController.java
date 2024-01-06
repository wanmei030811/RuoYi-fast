package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageFunction;
import com.ruoyi.project.customize.service.IPageFunctionService;
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
@RequestMapping("/customize/page-function")
public class PageFunctionController extends BaseController {
  private final String prefix = "customize/function";

  @Autowired
  private IPageFunctionService pageFunctionService;

  @RequiresPermissions("system:function:view")
  @GetMapping()
  public String function() {
    return prefix + "/function";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:function:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageFunction pageFunction) {
    startPage();
    List<PageFunction> list = pageFunctionService.selectPageFunctionList(pageFunction);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:function:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageFunction pageFunction) {
    List<PageFunction> list = pageFunctionService.selectPageFunctionList(pageFunction);
    ExcelUtil<PageFunction> util = new ExcelUtil<PageFunction>(PageFunction.class);
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
  @RequiresPermissions("system:function:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageFunction pageFunction) {
    return toAjax(pageFunctionService.insertPageFunction(pageFunction));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:function:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageFunction pageFunction = pageFunctionService.selectPageFunctionByTableId(tableId);
    modelMap.put("pageFunction", pageFunction);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:function:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageFunction pageFunction) {
    return toAjax(pageFunctionService.updatePageFunction(pageFunction));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:function:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageFunctionService.deletePageFunctionByTableIds(ids));
  }
}