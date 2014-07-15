package com.xwl.platform.dao;

import java.util.List;

import com.xwl.platform.model.SysRole;
import com.xwl.platform.model.SysUser;

public interface ISysUserDao extends IBaseDao<SysUser>
{

	SysUser getUserByName(String name);

	List<SysRole> getRolsByUserId(long userId);

	List<SysUser> getUsers(int firstResult, int maxResult);

}
