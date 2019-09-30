package com.vellechokre.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vellechokre.entity.PatientDetail;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface CommuncationService {

    /**
     * @param patients
     * @param message
     * @return
     */
    ResponseEntity sendSms(List<PatientDetail> patients, String message);
}
