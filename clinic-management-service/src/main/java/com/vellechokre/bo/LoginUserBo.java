package com.vellechokre.bo;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vellechokre.entity.Clinic;
import com.vellechokre.entity.master.LoginAuthority;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUserBo extends User {

    private static final long serialVersionUID = 1L;

    /**
     * @param username
     * @param password
     * @param enabled
     * @param accountNonExpired
     * @param credentialsNonExpired
     * @param accountNonLocked
     * @param authorities
     */
    public LoginUserBo(String username, String password, boolean enabled, boolean accountNonExpired,
                       boolean credentialsNonExpired, boolean accountNonLocked,
                       Collection<? extends GrantedAuthority> authorities) {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities);
    }

    public LoginUserBo(String username, String password, long id, Clinic clinic,
                       Set<BranchBo> branchs, List<LoginAuthority> loginAuthorities,
                       Date activeTill) {

        super(username, password, loginAuthorities);
        this.id = id;
        this.username = username;
        this.password = password;
        this.clinic = clinic;
        this.branchs = branchs;
        this.loginAuthorities = loginAuthorities;
        this.activeTill = activeTill;
    }

    private long id;

    private String username;

    @JsonIgnore
    private String password;

    private Clinic clinic;

    private Set<BranchBo> branchs = new HashSet<>();

    private List<LoginAuthority> loginAuthorities;

    private Date activeTill;

    /**
     * @return the id
     */
    public long getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {

        this.id = id;
    }

    /**
     * @return the username
     */
    @Override
    public String getUsername() {

        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {

        this.username = username;
    }

    /**
     * @return the password
     */
    @Override
    public String getPassword() {

        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * @return the clinic
     */
    public Clinic getClinic() {

        return clinic;
    }

    /**
     * @param clinic the clinic to set
     */
    public void setClinic(Clinic clinic) {

        this.clinic = clinic;
    }

    /**
     * @return the branchs
     */
    public Set<BranchBo> getBranchs() {

        return branchs;
    }

    /**
     * @param branchs the branchs to set
     */
    public void setBranchs(Set<BranchBo> branchs) {

        this.branchs = branchs;
    }

    /**
     * @return the loginAuthorities
     */
    public List<LoginAuthority> getLoginAuthorities() {

        return loginAuthorities;
    }

    /**
     * @param loginAuthorities the loginAuthorities to set
     */
    public void setLoginAuthorities(List<LoginAuthority> loginAuthorities) {

        this.loginAuthorities = loginAuthorities;
    }

    /**
     * @return the activeTill
     */
    public Date getActiveTill() {

        return activeTill;
    }

    /**
     * @param activeTill the activeTill to set
     */
    public void setActiveTill(Date activeTill) {

        this.activeTill = activeTill;
    }
}