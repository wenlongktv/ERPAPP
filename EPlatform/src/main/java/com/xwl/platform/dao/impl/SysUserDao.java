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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.xwl.platform.dao.ISysUserDao;
import com.xwl.platform.model.SysRole;
import com.xwl.platform.model.SysUser;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings({ "unchecked", "nls" })
@Repository
public class SysUserDao extends BaseDao<SysUser> implements ISysUserDao, UserDetailsService
{
	@Override
	public SysUser getUserByName(String name)
	{
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("username", name));
		return (SysUser) criteria.uniqueResult();
	}
	
	@Override
	public List<SysRole> getRolsByUserId(long userId)
	{
		List<SysRole> result = new ArrayList<SysRole>();
		String hql = "select role from SysRole role inner join role.users as user where user.id=:id";
		queryForObject(hql, new Long[] { userId });
		return result;
	}
	
	@Override
	public List<SysUser> getUsers(int firstResult, int maxResult)
	{
		Criteria criteria = createCriteria();
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResult);
		return criteria.list();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		return getUserByName(username);
	}
}
