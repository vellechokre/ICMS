package com.vellechokre.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity(name = EntityContant.APPOINTMENT)
public class Appointment extends BaseObjectWithIdAndBranchId {

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @Column(name = "appointment_start_date")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date appointmentStartDate;

    @Column(name = "appointment_end_date")
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date appointmentEndDate;

    private String notes;

    private boolean dayBeforeReminder;

    private boolean sameDayReminder;

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
     * @return the consultant
     */
    public Consultant getConsultant() {

        return consultant;
    }

    /**
     * @param consultant the consultant to set
     */
    public void setConsultant(final Consultant consultant) {

        this.consultant = consultant;
    }

    /**
     * @return the appointmentStartDate
     */
    public Date getAppointmentStartDate() {

        return appointmentStartDate;
    }

    /**
     * @param appointmentStartDate the appointmentStartDate to set
     */
    public void setAppointmentStartDate(final Date appointmentStartDate) {

        this.appointmentStartDate = appointmentStartDate;
    }

    /**
     * @return the appointmentEndDate
     */
    public Date getAppointmentEndDate() {

        return appointmentEndDate;
    }

    /**
     * @param appointmentEndDate the appointmentEndDate to set
     */
    public void setAppointmentEndDate(final Date appointmentEndDate) {

        this.appointmentEndDate = appointmentEndDate;
    }

    /**
     * @return the notes
     */
    public String getNotes() {

        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(final String notes) {

        this.notes = notes;
    }

    /**
     * @return the dayBeforeReminder
     */
    public boolean isDayBeforeReminder() {

        return dayBeforeReminder;
    }

    /**
     * @param dayBeforeReminder the dayBeforeReminder to set
     */
    public void setDayBeforeReminder(final boolean dayBeforeReminder) {

        this.dayBeforeReminder = dayBeforeReminder;
    }

    /**
     * @return the sameDayReminder
     */
    public boolean isSameDayReminder() {

        return sameDayReminder;
    }

    /**
     * @param sameDayReminder the sameDayReminder to set
     */
    public void setSameDayReminder(final boolean sameDayReminder) {

        this.sameDayReminder = sameDayReminder;
    }
}
