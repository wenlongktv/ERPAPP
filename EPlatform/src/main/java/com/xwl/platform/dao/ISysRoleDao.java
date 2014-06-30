package com.xwl.platform.dao;

import java.util.List;

import com.xwl.platform.model.SysRole;

public interface ISysRoleDao extends IBaseDao<SysRole>
{
	List<SysRole> getRolesByUserId(long userId);

	List<SysRole> getRolesByURLs(List<String> urlParams);

}
