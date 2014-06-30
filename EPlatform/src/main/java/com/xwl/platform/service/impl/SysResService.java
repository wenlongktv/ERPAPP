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

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xwl.platform.dao.ISysResourceDao;
import com.xwl.platform.model.SysResource;
import com.xwl.platform.model.SysRole;
import com.xwl.platform.service.ISysResService;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings(
{
        "unchecked", "nls"
})
@Service
@Transactional
public class SysResService implements ISysResService
{
    @Autowired
    private ISysResourceDao resourceDao;
    Logger                  logger = Logger.getLogger(this.getClass());

    @Override
    public void createRes(SysResource res)
    {
        this.resourceDao.insert(res);
    }

    @Override
    public void deleteRes(long resId)
    {
        this.resourceDao.deleteByKey(resId);
    }

    @Override
    public void updateRes(SysResource res)
    {
        this.resourceDao.update(res);
    }

    @Override
    public SysResource getRes(long resId)
    {
        return this.resourceDao.queryById(resId);
    }
    
    @Override
    public List<SysResource> getResourcesByRoleId(long roleId)
    {
        Criteria criteria = this.resourceDao.createCriteria();
        criteria.createAlias("roles", "roles");
        criteria.add(Restrictions.eq("roles.id", roleId));

        List<SysResource> result = criteria.list();
        if ( null == result )
        {
            getLogger().error("getResourcesByRoleId is failed!");
            return new ArrayList<SysResource>();
        }

        return result;
    }

    @Override
    public List<SysResource> getResources()
    {
        List<SysResource> result = this.resourceDao.getAllResources();
        if ( null == result || result.size() == 0 )
        {
            getLogger().error("Get Resources is failed, no resource found!");
            return new ArrayList<SysResource>();
        }
        return result;
    }

    @Override
    public Set<SysRole> getRolesByResUrl(String url)
    {
        Set<SysRole> roles = new HashSet<SysRole>();
        if ( StringUtils.isEmpty(url) )
        {
            getLogger().error("url is wrong!");
            return roles;
        }
        roles = this.resourceDao.getRolesByUrl(url);
        return roles;
    }

    /**
     * @return the logger
     */
    public Logger getLogger()
    {
        return this.logger;
    }

    /**
     * @param logger the logger to set
     */
    public void setLogger(Logger logger)
    {
        this.logger = logger;
    }

}
