/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xwl.platform.dao.ISysRoleDao;
import com.xwl.platform.model.SysRole;
import com.xwl.platform.service.ISysRoleService;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings(
{
        "unchecked", "nls", "javadoc"
})
@Service
@Transactional
public class SysRoleService implements ISysRoleService
{
    @Autowired
    private ISysRoleDao roleDao;
    
    Logger              logger = Logger.getLogger(this.getClass());
    
    public SysRoleService()
    {
//    	roleDao = new SysRoleDao();
    }
    
    @Override
    public void createRole(SysRole role)
    {
        this.roleDao.insert(role);
    }

    @Override
    public void deleteRole(long roleId)
    {
        this.roleDao.deleteByKey(roleId);
    }

    @Override
    public void updateRole(SysRole role)
    {
        this.roleDao.update(role);
    }

    @Override
    public SysRole getRole(long roleId)
    {
        if ( roleId <= 0 )
        {
            return null;
        }
        return this.roleDao.queryById(roleId);
    }
    
    @Override
    public List<SysRole> getRolsByUserId(long userId)
    {
        Criteria criteria = this.roleDao.createCriteria();
        criteria.createAlias("users", "users");
        criteria.add(Restrictions.eq("users.id", userId));

        List<SysRole> result = criteria.list();
        if ( null == result )
        {
            this.logger.error("getRolsByUserId is failed!");
            return new ArrayList<SysRole>();
        }

        return result;
    }
    
    @Override
    public List<SysRole> getRoles()
    {
        Criteria criteria = this.roleDao.createCriteria();
        List<SysRole> result = criteria.list();
        if ( null == result )
        {
            this.logger.error("getRoles is failed!");
            return new ArrayList<SysRole>();
        }
        return result;
    }
    
    @Override
    public Set<SysRole> getRolesByResList(List<String> urlParams)
    {
        Set<SysRole> result = new HashSet<SysRole>();
        if (urlParams == null || urlParams.size() < 1)
        {
        	return result;
        }
        
        List<SysRole> roles = this.roleDao.getRolesByURLs(urlParams);
        if ( null == roles )
        {
            return result;
        }
        result = new HashSet<SysRole>(roles);

        return result;
    }

}
