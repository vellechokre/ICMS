package com.vellechokre.bo;

import java.util.List;

import com.vellechokre.entity.Patient;
import com.vellechokre.entity.Payment;
import com.vellechokre.entity.Visit;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class RecordVisit {

    private Patient patientDetail;

    private List<Visit> visitDetails;

    private Payment paymentDetail;

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
     * @return the visitDetails
     */
    public List<Visit> getVisitDetails() {

        return visitDetails;
    }

    /**
     * @param visitDetails the visitDetails to set
     */
    public void setVisitDetails(final List<Visit> visitDetails) {

        this.visitDetails = visitDetails;
    }

    /**
     * @return the paymentDetail
     */
    public Payment getPaymentDetail() {

        return paymentDetail;
    }

    /**
     * @param paymentDetail the paymentDetail to set
     */
    public void setPaymentDetail(final Payment paymentDetail) {

        this.paymentDetail = paymentDetail;
    }
}
