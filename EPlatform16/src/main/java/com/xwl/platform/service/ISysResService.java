package com.xwl.platform.service;

import java.util.List;
import java.util.Set;

import com.xwl.platform.model.SysResource;
import com.xwl.platform.model.SysRole;

public interface ISysResService
{
	void createRes(SysResource res);

	void deleteRes(long resId);

	void updateRes(SysResource res);

	SysResource getRes(long resId);

	List<SysResource> getResourcesByRoleId(long roleId);

	List<SysResource> getResources();

	Set<SysRole> getRolesByResUrl(String url);

}
