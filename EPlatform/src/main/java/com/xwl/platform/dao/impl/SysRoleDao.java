/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.xwl.platform.dao.ISysRoleDao;
import com.xwl.platform.model.SysRole;

/**
 * 
 * @author 212361441
 */

@SuppressWarnings({ "nls", "unchecked" })
@Repository
public class SysRoleDao extends BaseDao<SysRole> implements ISysRoleDao
{
	@Override
	public List<SysRole> getRolesByUserId(long userId)
	{
		final String hql = "select role from SysUser as user inner join user.roles as role where user.id = :userId";
		Query query = getSession().createQuery(hql).setCacheable(true);
		query.setParameter("userId", userId);
		return query.list();
	}
	
	@Override
    public List<SysRole> getRolesByURLs(List<String> urlParams)
    {
        final String hql = "select role from SysResource as res inner join res.roles as role where res.url in (:url)";
        Query query = getSession().createQuery(hql);
        query.setParameterList("url", urlParams);
        return query.list();
    }
}
