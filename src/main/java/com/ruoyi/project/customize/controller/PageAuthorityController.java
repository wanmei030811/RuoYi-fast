package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageAuthority;
import com.ruoyi.project.customize.service.IPageAuthorityService;
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
@RequestMapping("/customize/page-authority")
public class PageAuthorityController extends BaseController {
  private final String prefix = "customize/authority";

  @Autowired
  private IPageAuthorityService pageAuthorityService;

  @RequiresPermissions("system:authority:view")
  @GetMapping()
  public String authority() {
    return prefix + "/authority";
  }

  /**
   * 查询列表
   */
  @RequiresPermissions("system:authority:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageAuthority pageAuthority) {
    startPage();
    List<PageAuthority> list = pageAuthorityService.selectPageAuthorityList(pageAuthority);
    return getDataTable(list);
  }

  /**
   * 导出列表
   */
  @RequiresPermissions("system:authority:export")
  @Log(title = "", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageAuthority pageAuthority) {
    List<PageAuthority> list = pageAuthorityService.selectPageAuthorityList(pageAuthority);
    ExcelUtil<PageAuthority> util = new ExcelUtil<PageAuthority>(PageAuthority.class);
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
  @RequiresPermissions("system:authority:add")
  @Log(title = "", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageAuthority pageAuthority) {
    return toAjax(pageAuthorityService.insertPageAuthority(pageAuthority));
  }

  /**
   * 修改
   */
  @RequiresPermissions("system:authority:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageAuthority pageAuthority = pageAuthorityService.selectPageAuthorityByTableId(tableId);
    modelMap.put("pageAuthority", pageAuthority);
    return prefix + "/edit";
  }

  /**
   * 修改保存
   */
  @RequiresPermissions("system:authority:edit")
  @Log(title = "", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageAuthority pageAuthority) {
    return toAjax(pageAuthorityService.updatePageAuthority(pageAuthority));
  }

  /**
   * 删除
   */
  @RequiresPermissions("system:authority:remove")
  @Log(title = "", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageAuthorityService.deletePageAuthorityByTableIds(ids));
  }
}