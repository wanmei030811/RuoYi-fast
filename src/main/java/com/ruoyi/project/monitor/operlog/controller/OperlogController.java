package com.ruoyi.project.monitor.operlog.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.monitor.operlog.domain.OperLog;
import com.ruoyi.project.monitor.operlog.service.IOperLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志记录
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/operlog")
public class OperlogController extends BaseController {
  private final String prefix = "monitor/operlog";

  @Autowired
  private IOperLogService operLogService;

  @RequiresPermissions("monitor:operlog:view")
  @GetMapping()
  public String operlog() {
    return prefix + "/operlog";
  }

  @RequiresPermissions("monitor:operlog:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(OperLog operLog) {
    startPage();
    List<OperLog> list = operLogService.selectOperLogList(operLog);
    return getDataTable(list);
  }

  @Log(title = "操作日志", businessType = BusinessType.EXPORT)
  @RequiresPermissions("monitor:operlog:export")
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(OperLog operLog) {
    List<OperLog> list = operLogService.selectOperLogList(operLog);
    ExcelUtil<OperLog> util = new ExcelUtil<OperLog>(OperLog.class);
    return util.exportExcel(list, "操作日志");
  }

  @Log(title = "操作日志", businessType = BusinessType.DELETE)
  @RequiresPermissions("monitor:operlog:remove")
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(operLogService.deleteOperLogByIds(ids));
  }

  @RequiresPermissions("monitor:operlog:detail")
  @GetMapping("/detail/{operId}")
  public String detail(@PathVariable("operId") Long operId, ModelMap modelMap) {
    modelMap.put("operLog", operLogService.selectOperLogById(operId));
    return prefix + "/detail";
  }

  @Log(title = "操作日志", businessType = BusinessType.CLEAN)
  @RequiresPermissions("monitor:operlog:remove")
  @PostMapping("/clean")
  @ResponseBody
  public AjaxResult clean() {
    operLogService.cleanOperLog();
    return success();
  }
}