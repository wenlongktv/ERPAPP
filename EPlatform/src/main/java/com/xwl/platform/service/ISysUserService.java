package com.xwl.platform.service;

import java.util.List;

import com.xwl.platform.model.SysUser;

public interface ISysUserService
{

	List<SysUser> searchUsers();

	int changePassword(long userId, String oldPwd, String newPwd);

	SysUser getCurrentLoginUser();

	SysUser getUserByName(String name);

	SysUser getUser(long userId);

	void updateUser(SysUser user);

	void deleteUser(long userId);

	void createUser(SysUser user);

}
