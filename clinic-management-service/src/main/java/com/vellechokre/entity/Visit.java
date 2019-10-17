package com.vellechokre.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vellechokre.entity.base.BaseObjectWithIdAndBranchId;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = EntityContant.VISITS)
public class Visit extends BaseObjectWithIdAndBranchId {

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String category;

    private String subCategory;

    private Integer amount;

    private Integer discount;

    private Integer netAmount;

    private boolean printBill;

    private boolean sendBill;

    /**
     * @return the patient
     */
    public Patient getPatient() {

        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(final Patient patient) {

        this.patient = patient;
    }

    /**
     * @return the category
     */
    public String getCategory() {

        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(final String category) {

        this.category = category;
    }

    /**
     * @return the subCategory
     */
    public String getSubCategory() {

        return subCategory;
    }

    /**
     * @param subCategory the subCategory to set
     */
    public void setSubCategory(final String subCategory) {

        this.subCategory = subCategory;
    }

    /**
     * @return the amount
     */
    public Integer getAmount() {

        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(final Integer amount) {

        this.amount = amount;
    }

    /**
     * @return the discount
     */
    public Integer getDiscount() {

        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(final Integer discount) {

        this.discount = discount;
    }

    /**
     * @return the netAmount
     */
    public Integer getNetAmount() {

        return netAmount;
    }

    /**
     * @param netAmount the netAmount to set
     */
    public void setNetAmount(final Integer netAmount) {

        this.netAmount = netAmount;
    }

    /**
     * @return the printBill
     */
    public boolean isPrintBill() {

        return printBill;
    }

    /**
     * @param printBill the printBill to set
     */
    public void setPrintBill(final boolean printBill) {

        this.printBill = printBill;
    }

    /**
     * @return the sendBill
     */
    public boolean isSendBill() {

        return sendBill;
    }

    /**
     * @param sendBill the sendBill to set
     */
    public void setSendBill(final boolean sendBill) {

        this.sendBill = sendBill;
    }
}
