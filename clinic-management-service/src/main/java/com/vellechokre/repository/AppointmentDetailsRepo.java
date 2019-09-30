package com.vellechokre.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.AppointmentDetail;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface AppointmentDetailsRepo extends JpaRepository<AppointmentDetail, Integer> {

    AppointmentDetail findByPatientIdAndIsActiveTrue(Integer patientId);

    // List<AppointmentDetail> findAllIsActiveTrue();
    List<AppointmentDetail> findByIsActiveTrueAndAppointmentStartDateBetween(Date startDate,
                                                                             Date nextDate);
}
