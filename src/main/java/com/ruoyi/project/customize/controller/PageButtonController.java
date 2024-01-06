package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageButton;
import com.ruoyi.project.customize.service.IPageButtonService;
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
@RequestMapping("/customize/page-button")
public class PageButtonController extends BaseController {
  private final String prefix = "customize/button";

  @Autowired
  private IPageButtonService pageButtonService;

  @RequiresPermissions("system:button:view")
  @GetMapping()
  public String button() {
    return prefix + "/button";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:button:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageButton pageButton) {
    startPage();
    List<PageButton> list = pageButtonService.selectPageButtonList(pageButton);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:button:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageButton pageButton) {
    List<PageButton> list = pageButtonService.selectPageButtonList(pageButton);
    ExcelUtil<PageButton> util = new ExcelUtil<PageButton>(PageButton.class);
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
  @RequiresPermissions("system:button:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageButton pageButton) {
    return toAjax(pageButtonService.insertPageButton(pageButton));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:button:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageButton pageButton = pageButtonService.selectPageButtonByTableId(tableId);
    modelMap.put("pageButton", pageButton);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:button:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageButton pageButton) {
    return toAjax(pageButtonService.updatePageButton(pageButton));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:button:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageButtonService.deletePageButtonByTableIds(ids));
  }
}