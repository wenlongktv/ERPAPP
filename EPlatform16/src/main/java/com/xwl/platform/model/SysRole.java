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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "pub_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysRole implements Serializable
{
    private static final long serialVersionUID = 5787388259172670136L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long              id;
    @Column
    private String            name;

    @ManyToMany(cascade =
    {
            CascadeType.PERSIST, CascadeType.MERGE
    }, targetEntity = SysResource.class)
    @JoinTable(name = "pub_role_res", joinColumns =
    {
        @JoinColumn(name = "role_id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "res_id")
    })
    @JsonIgnore
    private Set<SysResource>  resources        = new HashSet<SysResource>();

    /**
     * 
     */
    public SysRole()
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
     * @param id the id to set
     */
    public void setId(long id)
    {
        this.id = id;
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

    /**
     * @return the resources
     */
    public Set<SysResource> getResources()
    {
        return this.resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(Set<SysResource> resources)
    {
        this.resources = resources;
    }

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
        SysRole other = (SysRole) obj;
        if ( this.id != other.id ) return false;
        return true;
    }

}
