package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageList;
import com.ruoyi.project.customize.service.IPageListService;
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
@RequestMapping("/customize/page-list")
public class PageListController extends BaseController {
  private final String prefix = "customize/list";

  @Autowired
  private IPageListService pageListService;

  @RequiresPermissions("system:list:view")
  @GetMapping()
  public String list() {
    return prefix + "/list";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:list:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageList pageList) {
    startPage();
    List<PageList> list = pageListService.selectPageListList(pageList);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:list:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageList pageList) {
    List<PageList> list = pageListService.selectPageListList(pageList);
    ExcelUtil<PageList> util = new ExcelUtil<PageList>(PageList.class);
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
  @RequiresPermissions("system:list:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageList pageList) {
    return toAjax(pageListService.insertPageList(pageList));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:list:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageList pageList = pageListService.selectPageListByTableId(tableId);
    modelMap.put("pageList", pageList);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:list:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageList pageList) {
    return toAjax(pageListService.updatePageList(pageList));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:list:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageListService.deletePageListByTableIds(ids));
  }
}