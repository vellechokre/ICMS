package com.vellechokre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.Patient;
import com.vellechokre.entity.Payment;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

    List<Payment> findByPatient(Patient patientDetail);
}
