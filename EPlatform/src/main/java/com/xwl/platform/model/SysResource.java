package com.xwl.platform.model;

/*

 * Copyright (c) 2013 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author 212361441
 */
@Entity
@Table(name = "pub_resource")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class SysResource implements Serializable
{
    private static final long serialVersionUID = 6238613827116850848L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long              id;
    @Column
    private String            name;
    @Column
    private String            url;

    @ManyToMany(targetEntity = SysRole.class, fetch = FetchType.LAZY, cascade =
    {
            CascadeType.MERGE, CascadeType.PERSIST
    }, mappedBy = "resources")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<SysRole>      roles            = new HashSet<SysRole>();

    /**
     * 这个构造函数必须有
     */
    public SysResource()
    {
    }

    /**
     * @return the id
     */
    public long getId()
    {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @return the url
     */
    public String getUrl()
    {
        return this.url;
    }

    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * @return the roles
     */
    public Set<SysRole> getRoles()
    {
        return this.roles;
    }

    /**
     * @param roles
     *            the roles to set
     */
    public void setRoles(Set<SysRole> roles)
    {
        this.roles = roles;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        SysResource other = (SysResource) obj;
        if ( this.id != other.id ) return false;
        return true;
    }

}
