package com.vellechokre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.vellechokre.entity.base.BaseObjectWithIdAndBranchId;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = EntityContant.CONSULTANT)
public class Consultant extends BaseObjectWithIdAndBranchId {

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "email_id")
    private String emailId;

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {

        this.name = name;
    }

    /**
     * @return the number
     */
    public String getNumber() {

        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(final String number) {

        this.number = number;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {

        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(final String emailId) {

        this.emailId = emailId;
    }
}
