package com.vellechokre.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vellechokre.bo.RecordVisit;
import com.vellechokre.entity.PatientDetail;
import com.vellechokre.entity.PaymentDetails;
import com.vellechokre.entity.VisitDetails;
import com.vellechokre.repository.PatientDetailRepo;
import com.vellechokre.repository.PaymentDetailsRepo;
import com.vellechokre.repository.VisitDetailsRepo;
import com.vellechokre.services.VisitService;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDetailsRepo visitRepo;

    @Autowired
    private PaymentDetailsRepo paymentRepo;

    @Autowired
    private PatientDetailRepo patientRepo;

    @Override
    public void recordVisit(RecordVisit recordVisit) {

        if (!CollectionUtils.isEmpty(recordVisit.getVisitDetails())) {
            visitRepo.saveAll(recordVisit.getVisitDetails());
        }
        if (null != recordVisit.getPaymentDetail()) {
            paymentRepo.save(recordVisit.getPaymentDetail());
        }
        Integer netAmount = Integer.valueOf(0);
        Integer amountPaid = Integer.valueOf(0);
        Integer pendingAmount = Integer.valueOf(0);
        final PatientDetail patientDetail = recordVisit.getPatientDetail();
        final List<VisitDetails> visits = visitRepo.findByPatient(patientDetail);
        for (final VisitDetails visit : visits) {
            System.out.println(visit.getNetAmount());
            netAmount = netAmount + visit.getNetAmount();
        }
        System.out.println("==================");
        final List<PaymentDetails> payments = paymentRepo.findByPatient(patientDetail);
        for (final PaymentDetails payment : payments) {
            System.out.println(payment.getAmountPaid());
            amountPaid = amountPaid + payment.getAmountPaid();
        }
        pendingAmount = netAmount - amountPaid;
        patientDetail.setTotalAmount(netAmount);
        patientDetail.setPendingAmount(pendingAmount);
        patientRepo.save(patientDetail);
    }
}
