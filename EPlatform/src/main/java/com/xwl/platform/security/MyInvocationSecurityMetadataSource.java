/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xwl.platform.model.SysResource;
import com.xwl.platform.model.SysRole;
import com.xwl.platform.service.ISysResService;
import com.xwl.platform.service.ISysRoleService;

/**
 * 
 * @author 212361441
 * 
 *         最核心的地方，就是提供某个资源对应的权限定义，
 *         即 getAttributes方法返回的结果。
 *         此类在初始化时，应该取到所有资源及其对应角色的定义.
 */
@Component("MyInvocationSecurityMetadataSource")
public class MyInvocationSecurityMetadataSource
        implements FilterInvocationSecurityMetadataSource
{
	@Autowired
    private ISysResService  resService;
	@Autowired
    private ISysRoleService roleService;

    /*
     * 根据URL，找到相关的角色。
     */
    
    public MyInvocationSecurityMetadataSource()
    {
//    	this.resService = new SysResService();
//    	this.roleService = new SysRoleService();
    }
    
    @SuppressWarnings("deprecation")
	@Transactional
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException
    {
    	SecurityContext userDetails = SecurityContextHolder.getContext();
    	if (!userDetails.getAuthentication().isAuthenticated())
    	{
    		throw new UsernameNotFoundException("user is not exist!");
    	}
    			
        // object是一个 URL，被用户请求的 url
        HttpServletRequest userRequest = ((FilterInvocation) object).getHttpRequest();

        // 根据用户点击的Url把相关角色关联起来
        List<SysResource> resources = this.resService.getResources();
        
        RequestMatcher aMatcher = null;
        Collection<ConfigAttribute> cAttributes = new HashSet<ConfigAttribute>();
        
        ArrayList<String> urlParams = new ArrayList<String>();
        for (SysResource resource : resources)
        {
            String resUrl = resource.getUrl();
            if ( StringUtils.isEmpty(resUrl) )
            {
                continue;
            }
            aMatcher = new AntPathRequestMatcher(resUrl);
            if ( aMatcher.matches(userRequest) )
            {
//                Set<SysRole> roles = this.roleService.getRolesByURL(resUrl);
//                cAttributes.addAll(roles);
            	urlParams.add(resUrl);
            }
        }
        
        Set<SysRole> roles = this.roleService.getRolesByResList(urlParams);
        cAttributes.addAll(roles);
        
        return cAttributes;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
        Collection<ConfigAttribute> cAttributes = new ArrayList<ConfigAttribute>();

        if ( null == this.roleService )
        {
            return null;
        }
        List<SysRole> roles = this.roleService.getRoles();
        cAttributes.addAll(roles);
        return cAttributes;
    }

    @Override
    public boolean supports(Class<?> paramClass)
    {
        return FilterInvocation.class.isAssignableFrom(paramClass);
    }
}
