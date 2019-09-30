package com.vellechokre.services;

import org.springframework.http.ResponseEntity;

import com.vellechokre.bo.PatientData;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface PatientService {

    ResponseEntity createPatient(PatientData patientData);

    ResponseEntity saveDetail(PatientData patientData);

    /**
     * @param id
     * @return
     */
    PatientData findById(Integer id);
}
