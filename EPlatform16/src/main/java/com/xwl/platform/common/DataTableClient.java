/*
 * Copyright (c) 2014 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.common;

/**
 * datatables提交到后台的参数
 * 
 * @author 212361441
 */
public class DataTableClient
{
    /**
     * Display start point in the current data set
     */
    private int     iDisplayStart;
    /**
     * Number of records that the table can display in the current draw. It is expected that the number of records returned will be equal to this number, unless
     * the server has fewer records to return.
     */
    private int     iDisplayLength;
    /**
     * Number of columns being displayed (useful for getting individual column search info)
     */
    private int     iColumns;
    /**
     * Global search field
     */
    private String  sSearch;
    /**
     * True if the global filter should be treated as a regular expression for advanced filtering, false if not.
     */
    private boolean bRegex;
    /**
     * Indicator for if a column is flagged as searchable or not on the client-side
     */
    private boolean bSearchable_[];
    /**
     * Individual column filter
     */
    private String  sSearch_[];
    /**
     * True if the individual column filter should be treated as a regular expression for advanced filtering, false if not
     */
    private boolean bRegex_[];
    /**
     * Indicator for if a column is flagged as sortable or not on the client-side
     */
    private boolean bSortable_[];
    /**
     * Number of columns to sort on
     */
    private int     iSortingCols;
    /**
     * Column being sorted on (you will need to decode this number for your database)
     */
    private int     iSortCol_[];
    /**
     * Direction to be sorted - "desc" or "asc".
     */
    private String  sSortDir_[];
    /**
     * The value specified by mDataProp for each column. This can be useful for ensuring that the processing of data is independent from the order of the
     * columns.
     */
    private String  mDataProp_[];
    /**
     * Information for DataTables to use for rendering.
     */
    private String  sEcho;

    /**
     * @return the iDisplayStart
     */
    public int getiDisplayStart()
    {
        return this.iDisplayStart;
    }

    /**
     * @param iDisplayStart the iDisplayStart to set
     */
    public void setiDisplayStart(int iDisplayStart)
    {
        this.iDisplayStart = iDisplayStart;
    }

    /**
     * @return the iDisplayLength
     */
    public int getiDisplayLength()
    {
        return this.iDisplayLength;
    }

    /**
     * @param iDisplayLength the iDisplayLength to set
     */
    public void setiDisplayLength(int iDisplayLength)
    {
        this.iDisplayLength = iDisplayLength;
    }

    /**
     * @return the iColumns
     */
    public int getiColumns()
    {
        return this.iColumns;
    }

    /**
     * @param iColumns the iColumns to set
     */
    public void setiColumns(int iColumns)
    {
        this.iColumns = iColumns;
    }

    /**
     * @return the sSearch
     */
    public String getsSearch()
    {
        return this.sSearch;
    }

    /**
     * @param sSearch the sSearch to set
     */
    public void setsSearch(String sSearch)
    {
        this.sSearch = sSearch;
    }

    /**
     * @return the bRegex
     */
    public boolean isbRegex()
    {
        return this.bRegex;
    }

    /**
     * @param bRegex the bRegex to set
     */
    public void setbRegex(boolean bRegex)
    {
        this.bRegex = bRegex;
    }

    /**
     * @return the bSearchable_
     */
    public boolean[] getbSearchable_()
    {
        return this.bSearchable_;
    }

    /**
     * @param bSearchable_ the bSearchable_ to set
     */
    public void setbSearchable_(boolean[] bSearchable_)
    {
        this.bSearchable_ = bSearchable_;
    }

    /**
     * @return the sSearch_
     */
    public String[] getsSearch_()
    {
        return this.sSearch_;
    }

    /**
     * @param sSearch_ the sSearch_ to set
     */
    public void setsSearch_(String[] sSearch_)
    {
        this.sSearch_ = sSearch_;
    }

    /**
     * @return the bRegex_
     */
    public boolean[] getbRegex_()
    {
        return this.bRegex_;
    }

    /**
     * @param bRegex_ the bRegex_ to set
     */
    public void setbRegex_(boolean[] bRegex_)
    {
        this.bRegex_ = bRegex_;
    }

    /**
     * @return the bSortable_
     */
    public boolean[] getbSortable_()
    {
        return this.bSortable_;
    }

    /**
     * @param bSortable_ the bSortable_ to set
     */
    public void setbSortable_(boolean[] bSortable_)
    {
        this.bSortable_ = bSortable_;
    }

    /**
     * @return the iSortingCols
     */
    public int getiSortingCols()
    {
        return this.iSortingCols;
    }

    /**
     * @param iSortingCols the iSortingCols to set
     */
    public void setiSortingCols(int iSortingCols)
    {
        this.iSortingCols = iSortingCols;
    }

    /**
     * @return the iSortCol_
     */
    public int[] getiSortCol_()
    {
        return this.iSortCol_;
    }

    /**
     * @param iSortCol_ the iSortCol_ to set
     */
    public void setiSortCol_(int[] iSortCol_)
    {
        this.iSortCol_ = iSortCol_;
    }

    /**
     * @return the sSortDir_
     */
    public String[] getsSortDir_()
    {
        return this.sSortDir_;
    }

    /**
     * @param sSortDir_ the sSortDir_ to set
     */
    public void setsSortDir_(String[] sSortDir_)
    {
        this.sSortDir_ = sSortDir_;
    }

    /**
     * @return the mDataProp_
     */
    public String[] getmDataProp_()
    {
        return this.mDataProp_;
    }

    /**
     * @param mDataProp_ the mDataProp_ to set
     */
    public void setmDataProp_(String[] mDataProp_)
    {
        this.mDataProp_ = mDataProp_;
    }

    /**
     * @return the sEcho
     */
    public String getsEcho()
    {
        return this.sEcho;
    }

    /**
     * @param sEcho the sEcho to set
     */
    public void setsEcho(String sEcho)
    {
        this.sEcho = sEcho;
    }

}
