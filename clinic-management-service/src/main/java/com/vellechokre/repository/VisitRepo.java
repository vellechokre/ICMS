package com.vellechokre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.Patient;
import com.vellechokre.entity.Visit;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface VisitRepo extends JpaRepository<Visit, Integer> {

    List<Visit> findByPatient(Patient patientDetail);
}
