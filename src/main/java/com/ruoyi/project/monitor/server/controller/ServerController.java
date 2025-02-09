package com.ruoyi.project.monitor.server.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.monitor.server.domain.Server;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 服务器监控
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/monitor/server")
public class ServerController extends BaseController {
  private final String prefix = "monitor/server";

  @RequiresPermissions("monitor:server:view")
  @GetMapping()
  public String server(ModelMap modelMap) throws Exception {
    Server server = new Server();
    server.copyTo();
    modelMap.put("server", server);
    return prefix + "/server";
  }
}