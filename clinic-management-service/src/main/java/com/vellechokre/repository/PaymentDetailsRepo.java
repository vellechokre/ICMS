package com.vellechokre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.PatientDetail;
import com.vellechokre.entity.PaymentDetails;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Integer> {

    List<PaymentDetails> findByPatient(PatientDetail patientDetail);
}
