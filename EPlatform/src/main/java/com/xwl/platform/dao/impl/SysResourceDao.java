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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xwl.platform.dao.ISysResourceDao;
import com.xwl.platform.model.SysResource;
import com.xwl.platform.model.SysRole;

@SuppressWarnings({ "nls", "unchecked" })
@Repository
public class SysResourceDao extends BaseDao<SysResource> implements ISysResourceDao
{
	@Override
	public Set<SysRole> getRolesByUrl(String url)
	{
		Set<SysRole> roles = new HashSet<SysRole>();

		Criteria criteria = this.getSession().createCriteria(SysResource.class);
		criteria.add(Restrictions.eq("url", url));
		SysResource resource = (SysResource) criteria.uniqueResult();

		if (null != resource)
		{
			roles = resource.getRoles();
			return roles;
		}
		return roles;
	}
	
	@Override
	public List<SysResource> getAllResources()
	{
		final String hql = "from SysResource";
		Query query = getSession().createQuery(hql).setCacheable(true);
		stat();
		return query.list();
	}
	
	private void stat()
	{
		// -----------统计查询缓存-------------
		SessionFactory sf = this.getSession().getSessionFactory();
		long hitCount = sf.getStatistics().getQueryStatistics("from SysResource").getCacheHitCount();
		org.apache.log4j.Logger.getLogger(this.getClass()).info("cache hit count： " + hitCount);
	}

	
}
