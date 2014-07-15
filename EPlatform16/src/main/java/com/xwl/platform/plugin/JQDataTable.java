package com.xwl.platform.plugin;

public class JQDataTable
{
	private String sTitle;
	private String mDataProp;
	private String sClass = "center";
	private String sDefaultContent;
	private String sWidth;
	private boolean bVisible = true;
	private boolean bSortable = true;

	public String getsTitle()
	{
		return sTitle;
	}

	public void setsTitle(String sTitle)
	{
		this.sTitle = sTitle;
	}

	public String getmDataProp()
	{
		return mDataProp;
	}

	public void setmDataProp(String mDataProp)
	{
		this.mDataProp = mDataProp;
	}

	public String getsClass()
	{
		return sClass;
	}

	public void setsClass(String sClass)
	{
		this.sClass = sClass;
	}

	public String getsDefaultContent()
	{
		return sDefaultContent;
	}

	public void setsDefaultContent(String sDefaultContent)
	{
		this.sDefaultContent = sDefaultContent;
	}

	public String getsWidth()
	{
		return sWidth;
	}

	public void setsWidth(String sWidth)
	{
		this.sWidth = sWidth;
	}

	public boolean isbVisible()
	{
		return bVisible;
	}

	public void setbVisible(boolean bVisible)
	{
		this.bVisible = bVisible;
	}

	public boolean isbSortable()
	{
		return bSortable;
	}

	public void setbSortable(boolean bSortable)
	{
		this.bSortable = bSortable;
	}
}
