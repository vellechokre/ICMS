package com.vellechokre.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.vellechokre.entity.base.BaseObjectWithIdAndBranchId;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
@Entity(name = EntityContant.BRANCH)
public class Branch extends BaseObjectWithIdAndBranchId {

    private String code;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "clinic_details_t_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clinic clinic;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                mappedBy = "branchs")
    private Set<LoginUser> users = new HashSet<>();

    /**
     * @return the code
     */
    public String getCode() {

        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {

        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {

        this.address = address;
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
     * @return the users
     */
    public Set<LoginUser> getUsers() {

        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<LoginUser> users) {

        this.users = users;
    }
}
