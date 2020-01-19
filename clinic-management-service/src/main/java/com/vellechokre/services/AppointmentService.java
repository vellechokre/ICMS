package com.vellechokre.services;

import java.text.ParseException;
import java.util.List;

import com.vellechokre.bo.AppointmentBO;
import com.vellechokre.entity.Appointment;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 19, 2020
 */
public interface AppointmentService {

    /**
     * @param appointmentDetail
     * @return
     */
    Appointment save(Appointment appointmentDetail);

    /**
     * @return
     * @throws ParseException
     */
    List<AppointmentBO> fetchAll() throws ParseException;

    /**
     * @return
     * @throws ParseException
     */
    List<AppointmentBO> fetchTodaysAppointment() throws ParseException;
}
