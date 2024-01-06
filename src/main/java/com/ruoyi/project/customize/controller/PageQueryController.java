package com.ruoyi.project.customize.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.customize.domain.PageQuery;
import com.ruoyi.project.customize.service.IPageQueryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 页面查询条件Controller
 *
 * @author ruoyi
 * @date 2024-01-06
 */
@Controller
@RequestMapping("/customize/page-query")
public class PageQueryController extends BaseController {
  private final String prefix = "customize/query";

  @Autowired
  private IPageQueryService pageQueryService;

  @RequiresPermissions("system:query:view")
  @GetMapping()
  public String query() {
    return prefix + "/query";
  }

  /**
   * 查询页面查询条件列表
   */
  @RequiresPermissions("system:query:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(PageQuery pageQuery) {
    startPage();
    List<PageQuery> list = pageQueryService.selectPageQueryList(pageQuery);
    return getDataTable(list);
  }

  /**
   * 导出页面查询条件列表
   */
  @RequiresPermissions("system:query:export")
  @Log(title = "页面查询条件", businessType = BusinessType.EXPORT)
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(PageQuery pageQuery) {
    List<PageQuery> list = pageQueryService.selectPageQueryList(pageQuery);
    ExcelUtil<PageQuery> util = new ExcelUtil<PageQuery>(PageQuery.class);
    return util.exportExcel(list, "页面查询条件数据");
  }

  /**
   * 新增页面查询条件
   */
  @GetMapping("/add")
  public String add() {
    return prefix + "/add";
  }

  /**
   * 新增保存页面查询条件
   */
  @RequiresPermissions("system:query:add")
  @Log(title = "页面查询条件", businessType = BusinessType.INSERT)
  @PostMapping("/add")
  @ResponseBody
  public AjaxResult addSave(PageQuery pageQuery) {
    return toAjax(pageQueryService.insertPageQuery(pageQuery));
  }

  /**
   * 修改页面查询条件
   */
  @RequiresPermissions("system:query:edit")
  @GetMapping("/edit/{tableId}")
  public String edit(@PathVariable("tableId") Long tableId, ModelMap modelMap) {
    PageQuery pageQuery = pageQueryService.selectPageQueryByTableId(tableId);
    modelMap.put("pageQuery", pageQuery);
    return prefix + "/edit";
  }

  /**
   * 修改保存页面查询条件
   */
  @RequiresPermissions("system:query:edit")
  @Log(title = "页面查询条件", businessType = BusinessType.UPDATE)
  @PostMapping("/edit")
  @ResponseBody
  public AjaxResult editSave(PageQuery pageQuery) {
    return toAjax(pageQueryService.updatePageQuery(pageQuery));
  }

  /**
   * 删除页面查询条件
   */
  @RequiresPermissions("system:query:remove")
  @Log(title = "页面查询条件", businessType = BusinessType.DELETE)
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(pageQueryService.deletePageQueryByTableIds(ids));
  }
}