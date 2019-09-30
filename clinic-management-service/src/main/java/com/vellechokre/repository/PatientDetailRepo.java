package com.vellechokre.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.vellechokre.entity.PatientDetail;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface PatientDetailRepo extends JpaRepository<PatientDetail, Integer> {

    List<PatientDetail> findByFirstname(String firstname);

    @Override
    @RestResource(path = "byId")
    Optional<PatientDetail> findById(@Param("id") Integer id);

    @RestResource(path = "byPendingAmount")
    List<PatientDetail> findByPendingAmountGreaterThan(@Param("amount") Integer amount);

    List<PatientDetail> findByIsActiveTrueAndDobBetween(Date startDate, Date nextDate);
}
