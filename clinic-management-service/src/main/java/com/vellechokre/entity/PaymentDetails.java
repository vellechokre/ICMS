package com.vellechokre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vellechokre.entity.base.BaseObject;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = "PAYMENT_DETAILS_T")
public class PaymentDetails extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientDetail patient;

    private Integer amountPaid;

    private String note;

    /**
     * @return the id
     */
    public Integer getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {

        this.id = id;
    }

    /**
     * @return the patient
     */
    public PatientDetail getPatient() {

        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(final PatientDetail patient) {

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
