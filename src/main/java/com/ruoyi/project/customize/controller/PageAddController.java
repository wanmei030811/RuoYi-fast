package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageAdd;
import com.ruoyi.project.customize.service.IPageAddService;
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
@RequestMapping("/customize/page-add")
public class PageAddController extends BaseController {
  private final String prefix = "customize/add";

  @Autowired
  private IPageAddService pageAddService;

  @RequiresPermissions("system:add:view")
  @GetMapping()
  public String add() {
    return prefix + "/add";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:add:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageAdd pageAdd) {
    startPage();
    List<PageAdd> list = pageAddService.selectPageAddList(pageAdd);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:add:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageAdd pageAdd) {
    List<PageAdd> list = pageAddService.selectPageAddList(pageAdd);
    ExcelUtil<PageAdd> util = new ExcelUtil<PageAdd>(PageAdd.class);
    return util.exportExcel(list, "数据");
  }

  /**
   * 新增保存
   */
  @RequiresPermissions("system:add:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageAdd pageAdd) {
    return toAjax(pageAddService.insertPageAdd(pageAdd));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:add:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageAdd pageAdd = pageAddService.selectPageAddByTableId(tableId);
    modelMap.put("pageAdd", pageAdd);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:add:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageAdd pageAdd) {
    return toAjax(pageAddService.updatePageAdd(pageAdd));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:add:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageAddService.deletePageAddByTableIds(ids));
  }
}