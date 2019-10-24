package com.vellechokre.repository;

import java.util.Date;
import java.util.List;

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

    @RestResource(path = "byId")
    List<Patient> findByIdAndBranchId(@Param("id") Integer id, @Param("branchId") Integer branchId);

    @RestResource(path = "byPendingAmount")
    List<Patient> findByPendingAmountGreaterThanAndBranchId(@Param("amount") Integer amount,
                                                            @Param("branchId") Integer branchId);

    List<Patient> findByIsActiveTrueAndDobBetweenAndBranchId(Date startDate, Date nextDate,
                                                             @Param("branchId") Integer branchId);
}
