package com.vellechokre.bo;

import com.vellechokre.entity.Address;
import com.vellechokre.entity.Appointment;
import com.vellechokre.entity.Patient;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class PatientData {

    private Patient patientDetail;

    private Address addressDetail;

    private Appointment appointmentDetail;

    /**
     * @return the patientDetail
     */
    public Patient getPatientDetail() {

        return patientDetail;
    }

    /**
     * @param patientDetail the patientDetail to set
     */
    public void setPatientDetail(final Patient patientDetail) {

        this.patientDetail = patientDetail;
    }

    /**
     * @return the addressDetail
     */
    public Address getAddressDetail() {

        return addressDetail;
    }

    /**
     * @param addressDetail the addressDetail to set
     */
    public void setAddressDetail(final Address addressDetail) {

        this.addressDetail = addressDetail;
    }

    /**
     * @return the appointmentDetail
     */
    public Appointment getAppointmentDetail() {

        return appointmentDetail;
    }

    /**
     * @param appointmentDetail the appointmentDetail to set
     */
    public void setAppointmentDetail(final Appointment appointmentDetail) {

        this.appointmentDetail = appointmentDetail;
    }
}
