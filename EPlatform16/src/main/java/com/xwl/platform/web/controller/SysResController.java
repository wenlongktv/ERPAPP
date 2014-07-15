package com.xwl.platform.web.controller;
/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xwl.platform.dao.ISysResourceDao;
import com.xwl.platform.model.SysResource;
import com.xwl.platform.service.ISysResService;
import com.xwl.platform.service.ISysRoleService;
import com.xwl.platform.service.impl.PageService;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings(
{
        "nls", "javadoc"
})
@Controller
@RequestMapping("/sysResource")
public class SysResController
{
    @Autowired
    ISysResService  resService;

    @Autowired
    ISysRoleService roleService;

    @Autowired
    ISysResourceDao resourceDao;
    
    @Autowired
    PageService pageService;
    
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * @return 跳转到用户管理页面
     */
    @RequestMapping
    public String index()
    {
        this.logger.info("index");
        return "sysMgt/resourceMgt";
    }
    
    @RequestMapping(value = "/ajax")
    public ModelAndView loadAjaxResourcePage(@RequestParam(value = "action", required = false) String action)
    {
        return new ModelAndView("sysMgt/addResource");
    }
    
    @RequestMapping(value = "/ajax/list")
    @ResponseBody
    public List<SysResource> listResource(@RequestParam(value = "name", required = false) String name)
    {
    	return resService.getResources();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteResource(@PathVariable long id)
    {
        this.logger.info("deleteRes id = " + id);
        if ( id <= 0 )
        {
            // TODO: 操作错误页面(还没有)
            // return "forward: /user/"; "redirect:/user"
        }
        this.resService.deleteRes(id);
        return "redirect:/sysResource";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveResource(SysResource resource)
    {
        if ( resource.getId() <= 0 )
        {
            this.resService.createRes(resource);
        }
        else
        {
            this.resService.updateRes(resource);
        }

        return "redirect:/sysResource";
    }
}
