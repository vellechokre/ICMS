package com.vellechokre.services.impl;

import java.util.Date;
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
import com.vellechokre.repository.projection.CategoryCountProjection;
import com.vellechokre.services.VisitService;
import com.vellechokre.util.DateUtil;

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
            recordVisit.getVisitDetails()
                    .forEach(item -> item.setPatient(recordVisit.getPatientDetail()));
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

    @Override
    public long getPatientVisitedInLastWeek() {

        return visitRepo.countByCreatedDateBetween(DateUtil.modifyDays(new Date(), 7, false),
                DateUtil.getCurrentEnd());
    }

    @Override
    public List<CategoryCountProjection> getPatientByTreatmentType() {

        return visitRepo.findVisitCount();
    }

    @Override
    public List<Visit> getVisitsByPatientId(Integer patientId) {

        return visitRepo.findByPatientId(patientId);
    }

    @Override
    public List<Visit> fetchAll() {

        return visitRepo.findAll();
    }
}
