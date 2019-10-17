package com.vellechokre.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vellechokre.entity.base.BaseObjectWithIdAndBranchId;
import com.vellechokre.json.CustomDateDeserializer;
import com.vellechokre.json.CustomDateSerializer;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = EntityContant.PATIENT)
public class Patient extends BaseObjectWithIdAndBranchId {

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "number")
    private String number;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dbo")
    // @DateTimeFormat(pattern = "dd-MM-yyyy")
    // @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date dob;

    @Column(name = "prefered_language")
    private String preferedLanguage;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "send_welcome")
    private boolean sendWelcomeMessage;

    @Column(name = "send_address")
    private boolean sendAddress;

    private Integer totalAmount;

    private Integer pendingAmount;

    /**
     * @return the firstname
     */
    public String getFirstname() {

        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(final String firstname) {

        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {

        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(final String lastname) {

        this.lastname = lastname;
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

    /**
     * @return the gender
     */
    public String getGender() {

        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(final String gender) {

        this.gender = gender;
    }

    /**
     * @return the dob
     */
    public Date getDob() {

        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(final Date dob) {

        this.dob = dob;
    }

    /**
     * @return the preferedLanguage
     */
    public String getPreferedLanguage() {

        return preferedLanguage;
    }

    /**
     * @param preferedLanguage the preferedLanguage to set
     */
    public void setPreferedLanguage(final String preferedLanguage) {

        this.preferedLanguage = preferedLanguage;
    }

    /**
     * @return the weight
     */
    public Integer getWeight() {

        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(final Integer weight) {

        this.weight = weight;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {

        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(final String bloodGroup) {

        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the sendWelcomeMessage
     */
    public boolean isSendWelcomeMessage() {

        return sendWelcomeMessage;
    }

    /**
     * @param sendWelcomeMessage the sendWelcomeMessage to set
     */
    public void setSendWelcomeMessage(final boolean sendWelcomeMessage) {

        this.sendWelcomeMessage = sendWelcomeMessage;
    }

    /**
     * @return the sendAddress
     */
    public boolean isSendAddress() {

        return sendAddress;
    }

    /**
     * @param sendAddress the sendAddress to set
     */
    public void setSendAddress(final boolean sendAddress) {

        this.sendAddress = sendAddress;
    }

    /**
     * @return the totalAmount
     */
    public Integer getTotalAmount() {

        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(final Integer totalAmount) {

        this.totalAmount = totalAmount;
    }

    /**
     * @return the pendingAmount
     */
    public Integer getPendingAmount() {

        return pendingAmount;
    }

    /**
     * @param pendingAmount the pendingAmount to set
     */
    public void setPendingAmount(final Integer pendingAmount) {

        this.pendingAmount = pendingAmount;
    }
}
