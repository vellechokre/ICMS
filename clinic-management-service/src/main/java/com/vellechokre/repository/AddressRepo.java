package com.vellechokre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.Address;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface AddressRepo extends JpaRepository<Address, Integer> {

    Address findByPatientId(Integer patientId);
}
