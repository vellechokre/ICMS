package com.vellechokre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.AddressDetails;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface AddressDetailsRepo extends JpaRepository<AddressDetails, Integer> {

    AddressDetails findByPatientId(Integer patientId);
}
