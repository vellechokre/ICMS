package com.vellechokre.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.vellechokre.entity.base.BaseObjectWithId;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
@Entity(name = EntityContant.CLINIC)
public class Clinic extends BaseObjectWithId {

    private String code;

    private String name;

    private String logoUrl;

    private boolean hasBranch;

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

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
     * @return the logoUrl
     */
    public String getLogoUrl() {

        return logoUrl;
    }

    /**
     * @param logoUrl the logoUrl to set
     */
    public void setLogoUrl(String logoUrl) {

        this.logoUrl = logoUrl;
    }

    /**
     * @return the hasBranch
     */
    public boolean isHasBranch() {

        return hasBranch;
    }

    /**
     * @param hasBranch the hasBranch to set
     */
    public void setHasBranch(boolean hasBranch) {

        this.hasBranch = hasBranch;
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
}
