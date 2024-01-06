package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageEdit;
import com.ruoyi.project.customize.service.IPageEditService;
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
@RequestMapping("/customize/page-edit")
public class PageEditController extends BaseController {
  private final String prefix = "customize/edit";

  @Autowired
  private IPageEditService pageEditService;

  @RequiresPermissions("system:edit:view")
  @GetMapping()
  public String edit() {
    return prefix + "/edit";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:edit:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageEdit pageEdit) {
    startPage();
    List<PageEdit> list = pageEditService.selectPageEditList(pageEdit);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:edit:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageEdit pageEdit) {
    List<PageEdit> list = pageEditService.selectPageEditList(pageEdit);
    ExcelUtil<PageEdit> util = new ExcelUtil<PageEdit>(PageEdit.class);
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
  @RequiresPermissions("system:edit:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageEdit pageEdit) {
    return toAjax(pageEditService.insertPageEdit(pageEdit));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:edit:edit")
  @GetMapping("/edit/{tableFieldId}")
  public String edit(@PathVariable("tableFieldId") Long tableFieldId, ModelMap modelMap) {
    PageEdit pageEdit = pageEditService.selectPageEditByTableFieldId(tableFieldId);
    modelMap.put("pageEdit", pageEdit);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:edit:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageEdit pageEdit) {
    return toAjax(pageEditService.updatePageEdit(pageEdit));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:edit:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageEditService.deletePageEditByTableFieldIds(ids));
  }
}