package com.vellechokre.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.vellechokre.entity.master.LoginAuthority;

@Entity(name = EntityContant.LOGIN_USER)
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull(message = "Username can't be null.")
    private String username;

    @Column
    // @JsonIgnore
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clinic_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clinic clinic;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_branch", joinColumns = {@JoinColumn(name = "user_id")},
               inverseJoinColumns = {@JoinColumn(name = "branch_id")})
    private Set<Branch> branchs = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<LoginAuthority> loginAuthorities;

    @CreatedDate
    @NotNull(message = "activeTill can't be null.")
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
    public Set<Branch> getBranchs() {

        return branchs;
    }

    /**
     * @param branchs the branchs to set
     */
    public void setBranchs(Set<Branch> branchs) {

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