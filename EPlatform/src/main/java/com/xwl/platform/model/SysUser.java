package com.xwl.platform.model;

import java.util.Collection;
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
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class SysUser
        implements UserDetails, CredentialsContainer
{
    private static final long serialVersionUID      = 1239280081275812858L;
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

    // @Transient
    @Column
    private final boolean     accountNonExpired     = true;
    @Column
    private final boolean     accountNonLocked      = true;
    @Column
    private final boolean     credentialsNonExpired = true;

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

    /**
     * @return the username
     */
    @Override
    public String getUsername()
    {
        return this.username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the password
     */
    @Override
    public String getPassword()
    {
        return this.password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the roles
     */
    @JsonIgnore
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

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.core.userdetails.UserDetails#getAuthorities
     * ()
     */
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return this.roles;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired
     * ()
     */
    @Override
    public boolean isAccountNonExpired()
    {
        return this.accountNonExpired;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked
     * ()
     */
    @Override
    public boolean isAccountNonLocked()
    {
        return this.accountNonLocked;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#
     * isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired()
    {
        return this.credentialsNonExpired;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
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

    /*
     * (non-Javadoc)
     * @see org.springframework.security.core.CredentialsContainer#eraseCredentials()
     */
    @Override
    public void eraseCredentials()
    {
        this.password = null;
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
        SysUser other = (SysUser) obj;
        if ( this.id != other.id ) return false;
        return true;
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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(": ");
        sb.append("Username: ").append(this.username).append("; ");
        sb.append("Password: [PROTECTED]; ");
        sb.append("Enabled: ").append(this.enabled).append("; ");
        sb.append("AccountNonExpired: ").append(this.accountNonExpired).append("; ");
        sb.append("credentialsNonExpired: ").append(this.credentialsNonExpired).append("; ");
        sb.append("AccountNonLocked: ").append(this.accountNonLocked).append("; ");

        if ( null != this.roles && !this.roles.isEmpty() )
        {
            sb.append("Granted Authorities: ");

            boolean first = true;
            for (GrantedAuthority auth : this.roles)
            {
                if ( !first )
                {
                    sb.append(",");
                }
                first = false;

                sb.append(auth);
            }
        }
        else
        {
            sb.append("Not granted any authorities");
        }

        return sb.toString();
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

}
