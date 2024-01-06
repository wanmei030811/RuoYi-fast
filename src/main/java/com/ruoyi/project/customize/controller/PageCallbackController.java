package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageCallback;
import com.ruoyi.project.customize.service.IPageCallbackService;
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
@RequestMapping("/customize/page-callback")
public class PageCallbackController extends BaseController {
  private final String prefix = "customize/callback";

  @Autowired
  private IPageCallbackService pageCallbackService;

  @RequiresPermissions("system:callback:view")
  @GetMapping()
  public String callback() {
    return prefix + "/callback";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:callback:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageCallback pageCallback) {
    startPage();
    List<PageCallback> list = pageCallbackService.selectPageCallbackList(pageCallback);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:callback:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageCallback pageCallback) {
    List<PageCallback> list = pageCallbackService.selectPageCallbackList(pageCallback);
    ExcelUtil<PageCallback> util = new ExcelUtil<PageCallback>(PageCallback.class);
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
  @RequiresPermissions("system:callback:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageCallback pageCallback) {
    return toAjax(pageCallbackService.insertPageCallback(pageCallback));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:callback:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageCallback pageCallback = pageCallbackService.selectPageCallbackByTableId(tableId);
    modelMap.put("pageCallback", pageCallback);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:callback:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageCallback pageCallback) {
    return toAjax(pageCallbackService.updatePageCallback(pageCallback));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:callback:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageCallbackService.deletePageCallbackByTableIds(ids));
  }
}