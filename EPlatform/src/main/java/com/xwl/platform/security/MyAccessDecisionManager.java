package com.xwl.platform.security;

/*
 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.xwl.platform.model.SysRole;

/**
 * 
 * @author 212361441
 */
@SuppressWarnings("javadoc")
@Component("MyAccessDecisionManager")
public class MyAccessDecisionManager
        implements AccessDecisionManager
{
    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException
    {
        if ( null == configAttributes || configAttributes.isEmpty() )
        {
        	//如果没有资源在数据库内，将不会运允许登陆。
        	//return;
        }

        for (ConfigAttribute configAttribute : configAttributes)
        {
            String needRole = ((SysRole) configAttribute).getAttribute();
            for (GrantedAuthority userRole : authentication.getAuthorities())
            {
                if ( needRole.equals(userRole.getAuthority()) )
                {  // ga is user's role.
                    return;
                }
            }
        }

        this.logger.info("No right");
        throw new AccessDeniedException("no right"); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.access.AccessDecisionManager#supports(org.springframework.security.access.ConfigAttribute)
     */
    @Override
    public boolean supports(ConfigAttribute configAttribute)
    {
        // TODO Auto-generated method stub
        return true;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.access.AccessDecisionManager#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> arg0)
    {
        // TODO Auto-generated method stub
        return true;
    }

}
