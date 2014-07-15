/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.xwl.platform.service.impl;

import java.util.Collection;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xwl.platform.common.Const;
import com.xwl.platform.dao.ISysUserDao;
import com.xwl.platform.model.SysUser;
import com.xwl.platform.service.ISysUserService;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings("nls")
@Service
@Transactional
public class SysUserService extends Observable implements ISysUserService
{
    @Autowired
    private ISysUserDao     userDao;

    private PasswordEncoder passwordEncoder;

    private Logger          logger = Logger.getLogger(this.getClass());

    @Override
    public void createUser(SysUser user)
    {
        if ( null == user )
        {
            return;
        }
        String encodePassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        this.userDao.insert(user);
        setChanged();
        notifyObservers(user.getId());
    }
    
    @Override
    public void deleteUser(long userId)
    {
        this.userDao.deleteByKey(userId);
    }
    
    @Override
    public void updateUser(SysUser user)
    {
        if ( null == user )
        {
            return;
        }
        String encodePassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        this.userDao.update(user);
    }
    
    @Override
    public SysUser getUser(long userId)
    {
        SysUser user = new SysUser();
        if ( userId <= 0 )
        {
            return user;
        }

        SysUser reUser = this.userDao.queryById(userId);
        if ( null == reUser )
        {
            this.logger.error("getUser is failed! user is not exist!");
            return user;
        }

        return reUser;
    }

    @Override
    public SysUser getUserByName(String name)
    {
        if ( StringUtils.isEmpty(name) )
        {
            this.logger.error("getByName is failed! username is null or empty!");
            return null;
        }

        return this.userDao.getUserByName(name);
    }
    
    @Override
    public int changePassword(long userId, String oldPwd, String newPwd)
    {
        if ( StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd) || userId <= 0 )
        {
            this.logger.error("changePassword is failed! parameters is null or empty!");
            return Const.RE_WRONG_PARAMETER;
        }

        SysUser sysUser = this.userDao.queryById(userId);
        if ( null == sysUser )
        {
            this.logger.error("changePassword is failed! sysUser is not exist!");
            return Const.RE_CUSTOMER_NOT_EXIT;
        }

        if ( !(this.passwordEncoder.matches(oldPwd, sysUser.getPassword())) )
        {
            this.logger.error("changePassword is failed! sysUser's oldPwd wrong!");
            return Const.RE_PASSWORD_WRONG;
        }

        String encodeNewPwd = this.passwordEncoder.encode(newPwd);
        sysUser.setPassword(encodeNewPwd);
        this.userDao.update(sysUser);
        return Const.RE_CODE_SUCCESS;
    }
    
    @Override
    public List<SysUser> searchUsers()
    {
    	return userDao.getUsers(0, 100000);
    }
    

    @SuppressWarnings("javadoc")
    @Autowired(required = false)
    public void addObservers(Collection<Observer> observers)
    {
        for (Observer observer : observers)
        {
            super.addObserver(observer);
        }
        return;
    }
}
