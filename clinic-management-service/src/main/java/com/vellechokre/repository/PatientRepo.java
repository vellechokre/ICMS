package com.vellechokre.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.vellechokre.entity.Patient;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface PatientRepo extends JpaRepository<Patient, Integer> {

    List<Patient> findByFirstname(String firstname);

    @Override
    @RestResource(path = "byId")
    Optional<Patient> findById(@Param("id") Integer id);

    @RestResource(path = "byPendingAmount")
    List<Patient> findByPendingAmountGreaterThan(@Param("amount") Integer amount);

    List<Patient> findByIsActiveTrueAndDobBetween(Date startDate, Date nextDate);
}
