package com.xwl.platform.service;

import java.util.List;
import java.util.Set;

import com.xwl.platform.model.SysRole;

public interface ISysRoleService
{
	void createRole(SysRole role);

	void deleteRole(long roleId);

	void updateRole(SysRole role);

	SysRole getRole(long roleId);

	List<SysRole> getRolsByUserId(long userId);

	List<SysRole> getRoles();

	Set<SysRole> getRolesByResList(List<String> urlParams);

}
