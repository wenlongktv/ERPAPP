package com.xwl.platform.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xwl.platform.model.SysUser;
import com.xwl.platform.service.ISysUserService;

/**
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 * 在这个类中，你就可以从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期等
 */

@SuppressWarnings("javadoc")
@Component("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService
{
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ISysUserService userService;

	@SuppressWarnings("nls")
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		// 根据登录名搜索用户
		SysUser user = this.userService.getUserByName(username);

		if (null == user)
		{
			throw new UsernameNotFoundException("user is not exist!");
		}

		if (user.isEnabled())
		{
			return user;
		}

		this.logger.error("user is unauthorizedAccess!");
		throw new UsernameNotFoundException("user is unauthorizedAccess!");
	}
}
