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

import java.util.ArrayList;
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

import com.xwl.platform.dao.ISysRoleDao;
import com.xwl.platform.model.SysResource;
import com.xwl.platform.model.SysRole;
import com.xwl.platform.service.ISysResService;
import com.xwl.platform.service.impl.PageService;
import com.xwl.platform.service.impl.SysRoleService;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings({ "nls", "javadoc" })
@Controller
@RequestMapping("/sysRole")
public class SysRoleController
{
	@Autowired
	SysRoleService roleService;

	@Autowired
	ISysResService resService;

	@Autowired
	ISysRoleDao roleDao;

	@Autowired
	PageService pageService;

	private static final String REDIRECT = "redirect:";

	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping
	public String index()
	{
		this.getLogger().info("showAllRoles");
		return "sysMgt/roleMgt";
	}

	@RequestMapping(value = "/ajax")
	@ResponseBody
	public ModelAndView loadAjaxPage(@RequestParam("action") String action)
	{
		if (action.equals("add"))
		{
			return new ModelAndView("sysMgt/addRole");
		}
		return null;
	}

	@RequestMapping(value = "/ajax/list")
	@ResponseBody
	public List<SysRole> searchRoles()
	{
		this.getLogger().info("searchRoles");
		return roleService.getRoles();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteRole(@PathVariable int id)
	{
		this.getLogger().info("deleteRole id = " + id);
		if (id <= 0)
		{
			// TODO: 操作错误页面(还没有)
		}
		this.roleService.deleteRole(id);
		return REDIRECT + "/sysRole";
	}

	@RequestMapping(value = "/sysRole", method = RequestMethod.POST)
	public String saveRole(SysRole role)
	{
		if (role.getId() < 1)
		{
			this.roleService.createRole(role);
		} else
		{
			this.roleService.updateRole(role);
		}
		return REDIRECT + "/sysRole";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView editRole(@PathVariable(value = "id") long roleId)
	{
		this.getLogger().info("editRole id = " + roleId);

		SysRole role = this.roleService.getRole(roleId);
		List<SysResource> resources = this.resService.getResourcesByRoleId(roleId);
		List<SysResource> allRes = filterUnSelectRes(resources);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("role", role);
		result.put("resources", resources);
		result.put("allRes", allRes);
		return new ModelAndView("sysMgt/editRole", result);
	}

	/**
	 * @param resources
	 * @return
	 */
	private List<SysResource> filterUnSelectRes(List<SysResource> resources)
	{
		List<SysResource> otherRes = new ArrayList<SysResource>();
		List<SysResource> allRes = this.resService.getResources();
		for (SysResource roleRes : resources)
		{
			for (SysResource res : allRes)
			{
				if (res.getId() == roleRes.getId())
				{
					otherRes.add(res);
					break;
				}
			}
		}

		allRes.removeAll(otherRes);
		return allRes;
	}

	/**
	 * @return 跳转至新增用户页
	 */
	@RequestMapping(value = "/addRole")
	public ModelAndView addRole()
	{
		this.getLogger().info("addRole");
		Map<String, Object> result = new HashMap<String, Object>();
		// 获取内存中的resources
		List<SysResource> resources = this.resService.getResources();
		result.put("resources", resources);
		return new ModelAndView("sysMgt/addRole", result);
	}

	/**
	 * @param role
	 *            前台form提交的role
	 * @param resIds
	 * @return 跳转至用户列表
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveRole(@ModelAttribute("role") SysRole role, @RequestParam("resIds") long[] resIds)
	{
		this.getLogger().info("saveRole");
		SysResource res;
		for (long id : resIds)
		{
			res = this.resService.getRes(id);
			role.getResources().add(res);
		}

		if (role.getId() <= 0)
		{
			this.roleService.createRole(role);
		} else
		{
			this.roleService.updateRole(role);
		}

		return REDIRECT + "/role";
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger()
	{
		return this.logger;
	}

	/**
	 * @param logger
	 *            the logger to set
	 */
	public void setLogger(Logger logger)
	{
		this.logger = logger;
	}

}
