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

import javax.validation.constraints.Min;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xwl.platform.common.Const;
import com.xwl.platform.dao.ISysUserDao;
import com.xwl.platform.model.SysRole;
import com.xwl.platform.model.SysUser;
import com.xwl.platform.service.IPageService;
import com.xwl.platform.service.ISysRoleService;
import com.xwl.platform.service.ISysUserService;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings(
{
        "nls", "javadoc"
})
@Controller
@RequestMapping("/user")
public class UserController
{
    @Autowired
    ISysUserService userService;

    @Autowired
    ISysRoleService roleService;

    @Autowired
    ISysUserDao     userDao;

    IPageService    pageService;

    private Logger  logger = Logger.getLogger(this.getClass());

    /**
     * @return 跳转到用户管理页
     */
    @RequestMapping
    public String index()
    {
        this.logger.info("index");
        return "sysMgt/userMgt";
    }

    @RequestMapping(value = "/list", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> searchUser(@RequestParam(value = "searchParam", required = false) String searchParam)
    {
    	List<SysUser> users = this.userService.searchUsers();
    	Map<String, Object> map = new HashMap<String, Object>();
        map.put("aaData", users);
        return map;
    }

    /**
     * @param id
     *            用戶id
     * @return 跳转至用户列�
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteSysUser(@PathVariable int id)
    {
        this.logger.info("deleteSysUser id = " + id);
        if ( id <= 0 )
        {
            // return "forward: /user/"; "redirect:/user"
        }
        this.userService.deleteUser(id);
        return "redirect:/user";
    }

    /**
     * @param userId
     *            用户id
     * @return 跳转至编辑页�
     */
    // @RequestMapping(value = "/editUser")
    // public ModelAndView editUser(@RequestParam(value = "id", required =
    // false) int id)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable(value = "id") long userId)
    {
        this.logger.info("editUser id = " + userId);

        SysUser user = this.userService.getUser(userId);
        List<SysRole> userRoles = this.roleService.getRolsByUserId(userId);
        List<SysRole> allRoles = filterUnSelectRoles(userRoles);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("user", user);
        result.put("roles", userRoles);
        result.put("allRoles", allRoles);
        return new ModelAndView("sysMgt/editSysUser", result);
    }

    /**
     * @return 跳转至新增用户页
     */
    @RequestMapping(value = "/addUser")
    public ModelAndView addUser()
    {
        this.logger.info("addUser");
        Map<String, Object> result = new HashMap<String, Object>();
        List<SysRole> roles = this.roleService.getRoles();
        result.put("roles", roles);
        return new ModelAndView("sysMgt/addSysUser", result);
    }

    /**
     * @param user
     *            前台form提交的user
     * @param roleIds
     * @return 跳转至用户列�
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveUser(SysUser user, @RequestParam(value = "roleIds", required = false) long[] roleIds)
    {
        this.logger.info("saveUser");
        SysRole role;

        if ( null == roleIds || roleIds.length == 0 )
        {
            user.getRoles().clear();
        }
        else
        {
            for (long id : roleIds)
            {
                role = this.roleService.getRole(id);
                user.getRoles().add(role);
            }
        }

        if ( user.getId() <= 0 )
        {
            this.userService.createUser(user);
        }
        else
        {
            this.userService.updateUser(user);
        }

        return "redirect:/user";
    }

    /**
     * @param sysUserId
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> password(@RequestParam(value = "sysUserId", required = true) @Min(5) long sysUserId,
            @RequestParam(value = "oldPwd", required = true) @NotBlank String oldPwd,
            @RequestParam(value = "newPwd", required = true) @NotBlank String newPwd)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        int reCode = this.userService.changePassword(sysUserId, oldPwd, newPwd);
        result.put(Const.RE_CODE, reCode);

        return result;
    }

    private List<SysRole> filterUnSelectRoles(List<SysRole> userRoles)
    {
        List<SysRole> otherRoles = new ArrayList<SysRole>();
        List<SysRole> allRoles = this.roleService.getRoles();
        for (SysRole userRole : userRoles)
        {
            for (SysRole role : allRoles)
            {
                if ( role.getId() == userRole.getId() )
                {
                    otherRoles.add(role);
                    break;
                }
            }
        }

        allRoles.removeAll(otherRoles);
        return allRoles;
    }
}
