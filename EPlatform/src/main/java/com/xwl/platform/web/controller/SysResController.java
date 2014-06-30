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



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/resource")
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
        return "sysMgt/resource";
    }

    /**
     * @param startIndex
     *            记录起始数，默认为0
     * @param pageSize
     *            每页显示记录数
     * @param sEcho
     *            请求datatable数(安全)
     * @return datatable的json对象
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<SysResource> listResource(@RequestParam(value = "name", required = false) String name)
    {
    	return resService.getResources();
    }

    /**
     * @param id
     *            用戶id
     * @return 跳转至用户列表
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteRes(@PathVariable long id)
    {
        this.logger.info("deleteRes id = " + id);
        if ( id <= 0 )
        {
            // TODO: 操作错误页面(还没有)
            // return "forward: /user/"; "redirect:/user"
        }
        this.resService.deleteRes(id);
        return "redirect:/resource";
    }

    /**
     * @param userId
     *            用户id
     * @return 跳转至编辑页面
     */
    // @RequestMapping(value = "/editUser")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView editRes(@PathVariable(value = "id") long resId)
    {
        this.logger.info("editUser id = " + resId);

        SysResource resource = this.resService.getRes(resId);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resource", resource);
        return new ModelAndView("sysMgt/editRes", result);
    }

    /**
     * @return 跳转至新增用户页
     */
    @RequestMapping(value = "/addRes")
    public ModelAndView addRes()
    {
        this.logger.info("addRes");
        return new ModelAndView("sysMgt/addRes", null);
    }

    /**
     * @param user
     *            前台form提交的user
     * @param roleIds
     * @return 跳转至用户列表
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveRes(@ModelAttribute("resource") SysResource resource)
    {
        this.logger.info("saveRes");

        if ( resource.getId() <= 0 )
        {
            this.resService.createRes(resource);
        }
        else
        {
            this.resService.updateRes(resource);
        }

        return "redirect:/resource";
    }
}
