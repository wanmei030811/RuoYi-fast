package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.Page;
import com.ruoyi.project.customize.service.IPageService;
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
@RequestMapping("/customize/page")
public class PageController extends BaseController {
  private final String prefix = "customize/page";

  @Autowired
  private IPageService pageService;

  @RequiresPermissions("system:page:view")
  @GetMapping()
  public String page() {
    return prefix + "/page";
  }

  /**
   * 查询页面列表
   */
  @RequiresPermissions("system:page:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(Page page) {
    startPage();
    List<Page> list = pageService.selectPageList(page);
    return getDataTable(list);
  }

  /**
   * 导出页面列表
   */
  @RequiresPermissions("system:page:export")
  @Log(title = "页面", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(Page page) {
    List<Page> list = pageService.selectPageList(page);
    ExcelUtil<Page> util = new ExcelUtil<Page>(Page.class);
    return util.exportExcel(list, "页面数据");
  }

  /**
   * 新增页面
   */
  @GetMapping("/add")
  public String add() {
    return prefix + "/add";
  }

  /**
   * 新增保存页面
   */
  @RequiresPermissions("system:page:add")
  @Log(title = "页面", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(Page page) {
    return toAjax(pageService.insertPage(page));
  }

  /**
   * 修改页面
   */
  @RequiresPermissions("system:page:edit")
  @GetMapping("/edit/{pageId}")
  public String edit(@PathVariable("pageId") Long pageId, ModelMap mmap) {
    Page page = pageService.selectPageByPageId(pageId);
    mmap.put("page", page);
    return prefix + "/edit";
  }

  /**
   * 修改保存页面
   */
  @RequiresPermissions("system:page:edit")
  @Log(title = "页面", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(Page page) {
    return toAjax(pageService.updatePage(page));
  }

  /**
   * 删除页面
   */
  @RequiresPermissions("system:page:remove")
  @Log(title = "页面", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageService.deletePageByPageIds(ids));
  }
}