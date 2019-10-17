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
@Entity(name = "PAYMENT_DETAILS_T")
public class Payment extends BaseObjectWithIdAndBranchId {

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Integer amountPaid;

    private String note;

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
     * @return the amountPaid
     */
    public Integer getAmountPaid() {

        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(final Integer amountPaid) {

        this.amountPaid = amountPaid;
    }

    /**
     * @return the note
     */
    public String getNote() {

        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(final String note) {

        this.note = note;
    }
}
