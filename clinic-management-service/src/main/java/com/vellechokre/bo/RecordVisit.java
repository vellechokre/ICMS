package com.vellechokre.bo;

import java.util.List;

import com.vellechokre.entity.PatientDetail;
import com.vellechokre.entity.PaymentDetails;
import com.vellechokre.entity.VisitDetails;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class RecordVisit {

    private PatientDetail patientDetail;

    private List<VisitDetails> visitDetails;

    private PaymentDetails paymentDetail;

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
     * @return the visitDetails
     */
    public List<VisitDetails> getVisitDetails() {

        return visitDetails;
    }

    /**
     * @param visitDetails the visitDetails to set
     */
    public void setVisitDetails(final List<VisitDetails> visitDetails) {

        this.visitDetails = visitDetails;
    }

    /**
     * @return the paymentDetail
     */
    public PaymentDetails getPaymentDetail() {

        return paymentDetail;
    }

    /**
     * @param paymentDetail the paymentDetail to set
     */
    public void setPaymentDetail(final PaymentDetails paymentDetail) {

        this.paymentDetail = paymentDetail;
    }
}
