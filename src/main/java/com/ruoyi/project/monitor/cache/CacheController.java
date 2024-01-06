package com.ruoyi.project.monitor.cache;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.service.CacheService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 缓存监控
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/cache")
public class CacheController extends BaseController {
  private final String prefix = "monitor/cache";

  @Autowired
  private CacheService cacheService;

  @RequiresPermissions("monitor:cache:view")
  @GetMapping()
  public String cache(ModelMap modelMap) {
    modelMap.put("cacheNames", cacheService.getCacheNames());
    return prefix + "/cache";
  }

  @RequiresPermissions("monitor:cache:view")
  @PostMapping("/getNames")
  public String getCacheNames(String fragment, ModelMap modelMap) {
    modelMap.put("cacheNames", cacheService.getCacheNames());
    return prefix + "/cache::" + fragment;
  }

  @RequiresPermissions("monitor:cache:view")
  @PostMapping("/getKeys")
  public String getCacheKeys(String fragment, String cacheName, ModelMap modelMap) {
    modelMap.put("cacheName", cacheName);
    modelMap.put("cacheKeys", cacheService.getCacheKeys(cacheName));
    return prefix + "/cache::" + fragment;
  }

  @RequiresPermissions("monitor:cache:view")
  @PostMapping("/getValue")
  public String getCacheValue(String fragment, String cacheName, String cacheKey, ModelMap modelMap) {
    modelMap.put("cacheName", cacheName);
    modelMap.put("cacheKey", cacheKey);
    modelMap.put("cacheValue", cacheService.getCacheValue(cacheName, cacheKey));
    return prefix + "/cache::" + fragment;
  }

  @RequiresPermissions("monitor:cache:view")
  @PostMapping("/clearCacheName")
  @ResponseBody
  public AjaxResult clearCacheName(String cacheName, ModelMap modelMap) {
    cacheService.clearCacheName(cacheName);
    return AjaxResult.success();
  }

  @RequiresPermissions("monitor:cache:view")
  @PostMapping("/clearCacheKey")
  @ResponseBody
  public AjaxResult clearCacheKey(String cacheName, String cacheKey, ModelMap modelMap) {
    cacheService.clearCacheKey(cacheName, cacheKey);
    return AjaxResult.success();
  }

  @RequiresPermissions("monitor:cache:view")
  @GetMapping("/clearAll")
  @ResponseBody
  public AjaxResult clearAll(ModelMap modelMap) {
    cacheService.clearAll();
    return AjaxResult.success();
  }
}