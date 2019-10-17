package com.vellechokre.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vellechokre.bo.RecordVisit;
import com.vellechokre.entity.Patient;
import com.vellechokre.entity.Payment;
import com.vellechokre.entity.Visit;
import com.vellechokre.repository.PatientRepo;
import com.vellechokre.repository.PaymentRepo;
import com.vellechokre.repository.VisitRepo;
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
    private VisitRepo visitRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private PatientRepo patientRepo;

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
        final Patient patientDetail = recordVisit.getPatientDetail();
        final List<Visit> visits = visitRepo.findByPatient(patientDetail);
        for (final Visit visit : visits) {
            System.out.println(visit.getNetAmount());
            netAmount = netAmount + visit.getNetAmount();
        }
        System.out.println("==================");
        final List<Payment> payments = paymentRepo.findByPatient(patientDetail);
        for (final Payment payment : payments) {
            System.out.println(payment.getAmountPaid());
            amountPaid = amountPaid + payment.getAmountPaid();
        }
        pendingAmount = netAmount - amountPaid;
        patientDetail.setTotalAmount(netAmount);
        patientDetail.setPendingAmount(pendingAmount);
        patientRepo.save(patientDetail);
    }
}
