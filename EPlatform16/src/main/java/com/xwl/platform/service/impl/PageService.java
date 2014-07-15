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

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xwl.platform.dao.impl.BaseDao;
import com.xwl.platform.model.Page;

/**
 * 
 * @author 212361448
 */
@Service
@Transactional
public class PageService
{
    Logger logger = Logger.getLogger(this.getClass());

    public Page page(BaseDao<Serializable> dao, int startIndex, int pageSize)
    {
        Criteria criteria = dao.createCriteria();
        long totalSize = dao.getRowCount(criteria);
        criteria.setProjection(null);
        List<Object> list = dao.findByCriteria(criteria, startIndex, pageSize);

        return new Page(list, totalSize, startIndex, pageSize);
    }
    
    public Page page(BaseDao<Serializable> dao, DetachedCriteria dc, int startIndex, int pageSize)
    {
        long totalSize = dao.getRowCount(dc);
        List<Object> list = dao.findByCriteria(dc, startIndex, pageSize);
        return new Page(list, totalSize, startIndex, pageSize);
    }
}
