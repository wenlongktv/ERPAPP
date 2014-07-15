package com.xwl.platform.dao;

import java.util.List;
import java.util.Set;

import com.xwl.platform.model.SysResource;
import com.xwl.platform.model.SysRole;

public interface ISysResourceDao extends IBaseDao<SysResource>
{
	List<SysResource> getAllResources();

	Set<SysRole> getRolesByUrl(String url);

}
