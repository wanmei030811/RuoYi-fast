package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageView;
import com.ruoyi.project.customize.service.IPageViewService;
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
@RequestMapping("/customize/page-view")
public class PageViewController extends BaseController {
  private final String prefix = "customize/view";

  @Autowired
  private IPageViewService pageViewService;

  @RequiresPermissions("system:view:view")
  @GetMapping()
  public String view() {
    return prefix + "/view";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:view:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageView pageView) {
    startPage();
    List<PageView> list = pageViewService.selectPageViewList(pageView);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:view:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageView pageView) {
    List<PageView> list = pageViewService.selectPageViewList(pageView);
    ExcelUtil<PageView> util = new ExcelUtil<PageView>(PageView.class);
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
  @RequiresPermissions("system:view:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageView pageView) {
    return toAjax(pageViewService.insertPageView(pageView));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:view:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageView pageView = pageViewService.selectPageViewByTableId(tableId);
    modelMap.put("pageView", pageView);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:view:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageView pageView) {
    return toAjax(pageViewService.updatePageView(pageView));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:view:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageViewService.deletePageViewByTableIds(ids));
  }
}