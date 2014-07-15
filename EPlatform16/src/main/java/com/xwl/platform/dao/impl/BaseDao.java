/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyrighT entityo the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.xwl.platform.dao.IBaseDao;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Repository
public class BaseDao<T extends Serializable> extends HibernateDaoSupport implements IBaseDao<T>
{
	private Class<T> entityClass;

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public BaseDao()
	{
		this.entityClass = null;
		Class<? extends BaseDao> c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType)
		{
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClass = (Class<T>) p[0];
		}
	}
	
	@Override
	public Session getCurrentSession()
	{
//		return this.sessionFactory.openSession();
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
	
	@Override
	public void deleteByKey(Long id)
	{
		String entity = this.entityClass.getName();
		String hql = "delete from " + entity + " where id = :id";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public T queryById(long id)
	{
		return (T) getCurrentSession().get(entityClass, id);
	}
	@Override
	public List<T> queryAll()
	{
		String hql = "from " + entityClass.getSimpleName();
		return queryForList(hql, null);
	}
	@Override
	public Criteria createCriteria()
	{
		return getCurrentSession().createCriteria(this.entityClass);
	}
	@Override
	public DetachedCriteria createDetachedCritera()
	{
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(this.entityClass);
		return detachedCriteria;
	}
	@Override
	public T queryForObject(String hql, Object[] params)
	{
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return (T) query.uniqueResult();
	}
	@Override
	public T queryForTopObject(String hql, Object[] params)
	{
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return (T) query.setFirstResult(0).setMaxResults(1).uniqueResult();
	}
	@Override
	public List<T> queryForList(String hql, Object[] params)
	{
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return query.list();
	}
	@Override
	public List<T> queryForList(final String hql, final Object[] params, final int recordNum)
	{
		Query query = getCurrentSession().createQuery(hql);
		setQueryParams(query, params);
		return query.setFirstResult(0).setMaxResults(recordNum).list();
	}

	private void setQueryParams(Query query, Object[] params)
	{
		if (null == params)
		{
			return;
		}
		for (int i = 0; i < params.length; i++)
		{
			query.setParameter(i, params[i]);
		}
	}
	@Override
	public long getRowCount(Criteria criteria)
	{
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	@Override
	public long getRowCount(DetachedCriteria detachedCriteria)
	{
		Criteria criteria = detachedCriteria.getExecutableCriteria(getCurrentSession());
		return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	@Override
	public List<Object> findByCriteria(Criteria criteria, int startIndex, int pageSize)
	{
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(startIndex + pageSize - 1);
		return criteria.list();
	}
	@Override
	public List<Object> findByCriteria(DetachedCriteria dc, int startIndex, int pageSize)
	{
		Criteria criteria = dc.getExecutableCriteria(getCurrentSession());
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(startIndex + pageSize - 1);
		return criteria.list();
	}

	@Override
	public void insert(Object entity)
	{
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Object entity)
	{
		getCurrentSession().update(entity);
	}
	
	@Override
	public void saveOrUpdate(Object entity)
	{
		getCurrentSession().saveOrUpdate(entity);
	}
}
