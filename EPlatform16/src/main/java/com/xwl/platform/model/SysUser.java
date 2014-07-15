package com.xwl.platform.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * @author 212361441
 */

@SuppressWarnings(
{
        "javadoc", "nls"
})
@Entity
@Table(name = "pub_user")
@JsonIgnoreProperties(value =
{
    "roles"
})
public class SysUser implements Serializable
{
	private static final long serialVersionUID = 9105428673146174720L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long              id;
    @Column(unique = true, nullable = true)
    private String            username;
    @Column
    private String            password;
    @Column
    private boolean           enabled;
    @Column
    // @NotBlank(message = "not blank!")
    private String            phone;
    @Column
    private String            email;

    @ManyToMany(targetEntity = SysRole.class, fetch = FetchType.EAGER, cascade =
    {
            CascadeType.MERGE, CascadeType.PERSIST
    })
    @JoinTable(name = "pub_user_role", joinColumns =
    {
        @JoinColumn(name = "user_id")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "role_id")
    })
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<SysRole>      roles                 = new HashSet<SysRole>();

    /**
     * 
     */
    public SysUser()
    {
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @JsonIgnore
    public Set<SysRole> getRoles()
    {
        return this.roles;
    }

    public void setRoles(Set<SysRole> roles)
    {
        this.roles = roles;
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void eraseCredentials()
    {
        this.password = null;
    }

    public boolean equals(Object obj)
    {
        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        SysUser other = (SysUser) obj;
        if ( this.id != other.id ) return false;
        return true;
    }
}
