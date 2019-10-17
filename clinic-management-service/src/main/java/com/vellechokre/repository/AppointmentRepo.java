package com.vellechokre.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.Appointment;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

    Appointment findByPatientIdAndIsActiveTrue(Integer patientId);

    // List<AppointmentDetail> findAllIsActiveTrue();
    List<Appointment> findByIsActiveTrueAndAppointmentStartDateBetween(Date startDate,
                                                                             Date nextDate);
}
