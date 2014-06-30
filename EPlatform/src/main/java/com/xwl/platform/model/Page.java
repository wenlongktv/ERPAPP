/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.model;

import java.util.List;

/**
 * 
 * @author 212361441
 */
public class Page
{
    private long totalSize  = 0;   // 总记录数
    private int  pageSize   = 10;  // 每页的条数
    private int  startIndex = 0;   // 从第几条记录开始显示
    private List<Object> list       = null;

    public Page()
    {
    }

    public Page(List<Object> list, long totalSize, int startIndex, int pageSize)
    {
        this.list = list;
        this.totalSize = totalSize;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    /**
     * @return the totalSize
     */
    public long getTotalSize()
    {
        return this.totalSize;
    }

    /**
     * @param totalSize the totalSize to set
     */
    public void setTotalSize(int totalSize)
    {
        this.totalSize = totalSize;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize()
    {
        return this.pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    /**
     * @return the startIndex
     */
    public int getStartIndex()
    {
        return this.startIndex;
    }

    /**
     * @param startIndex the startIndex to set
     */
    public void setStartIndex(int startIndex)
    {
        this.startIndex = startIndex;
    }

    /**
     * @return the list
     */
    public List<Object> getList()
    {
        return this.list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Object> list)
    {
        this.list = list;
    }

}
