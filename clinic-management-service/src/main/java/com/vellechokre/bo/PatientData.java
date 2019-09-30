package com.vellechokre.bo;

import com.vellechokre.entity.AddressDetails;
import com.vellechokre.entity.AppointmentDetail;
import com.vellechokre.entity.PatientDetail;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class PatientData {

    private PatientDetail patientDetail;

    private AddressDetails addressDetail;

    private AppointmentDetail appointmentDetail;

    /**
     * @return the patientDetail
     */
    public PatientDetail getPatientDetail() {

        return patientDetail;
    }

    /**
     * @param patientDetail the patientDetail to set
     */
    public void setPatientDetail(final PatientDetail patientDetail) {

        this.patientDetail = patientDetail;
    }

    /**
     * @return the addressDetail
     */
    public AddressDetails getAddressDetail() {

        return addressDetail;
    }

    /**
     * @param addressDetail the addressDetail to set
     */
    public void setAddressDetail(final AddressDetails addressDetail) {

        this.addressDetail = addressDetail;
    }

    /**
     * @return the appointmentDetail
     */
    public AppointmentDetail getAppointmentDetail() {

        return appointmentDetail;
    }

    /**
     * @param appointmentDetail the appointmentDetail to set
     */
    public void setAppointmentDetail(final AppointmentDetail appointmentDetail) {

        this.appointmentDetail = appointmentDetail;
    }
}
