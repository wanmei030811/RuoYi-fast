package com.ruoyi.project.monitor.job.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.monitor.job.domain.Job;
import com.ruoyi.project.monitor.job.domain.JobLog;
import com.ruoyi.project.monitor.job.service.IJobLogService;
import com.ruoyi.project.monitor.job.service.IJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调度日志操作处理
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/jobLog")
public class JobLogController extends BaseController {
  private final String prefix = "monitor/job";

  @Autowired
  private IJobService jobService;

  @Autowired
  private IJobLogService jobLogService;

  @RequiresPermissions("monitor:job:view")
  @GetMapping()
  public String jobLog(@RequestParam(value = "jobId", required = false) Long jobId, ModelMap modelMap) {
    if (StringUtils.isNotNull(jobId)) {
      Job job = jobService.selectJobById(jobId);
      modelMap.put("job", job);
    }
    return prefix + "/jobLog";
  }

  @RequiresPermissions("monitor:job:list")
  @PostMapping("/list")
  @ResponseBody
  public TableDataInfo list(JobLog jobLog) {
    startPage();
    List<JobLog> list = jobLogService.selectJobLogList(jobLog);
    return getDataTable(list);
  }

  @Log(title = "调度日志", businessType = BusinessType.EXPORT)
  @RequiresPermissions("monitor:job:export")
  @PostMapping("/export")
  @ResponseBody
  public AjaxResult export(JobLog jobLog) {
    List<JobLog> list = jobLogService.selectJobLogList(jobLog);
    ExcelUtil<JobLog> util = new ExcelUtil<JobLog>(JobLog.class);
    return util.exportExcel(list, "调度日志");
  }

  @Log(title = "调度日志", businessType = BusinessType.DELETE)
  @RequiresPermissions("monitor:job:remove")
  @PostMapping("/remove")
  @ResponseBody
  public AjaxResult remove(String ids) {
    return toAjax(jobLogService.deleteJobLogByIds(ids));
  }

  @RequiresPermissions("monitor:job:detail")
  @GetMapping("/detail/{jobLogId}")
  public String detail(@PathVariable("jobLogId") Long jobLogId, ModelMap modelMap) {
    modelMap.put("name", "jobLog");
    modelMap.put("jobLog", jobLogService.selectJobLogById(jobLogId));
    return prefix + "/detail";
  }

  @Log(title = "调度日志", businessType = BusinessType.CLEAN)
  @RequiresPermissions("monitor:job:remove")
  @PostMapping("/clean")
  @ResponseBody
  public AjaxResult clean() {
    jobLogService.cleanJobLog();
    return success();
  }
}