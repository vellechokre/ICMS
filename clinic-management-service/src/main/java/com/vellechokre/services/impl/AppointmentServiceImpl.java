package com.vellechokre.services.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.bo.AppointmentBO;
import com.vellechokre.entity.Appointment;
import com.vellechokre.repository.AppointmentRepo;
import com.vellechokre.services.AppointmentService;
import com.vellechokre.util.DateUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 19, 2020
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Override
    public Appointment save(Appointment appointmentDetail) {

        Appointment appointmentsOld = appointmentRepo
                .findByPatientIdAndIsActiveTrue(appointmentDetail.getPatient().getId());
        if (null != appointmentsOld) {
            appointmentsOld.setIsActive(false);
            appointmentRepo.save(appointmentsOld);
        }
        return appointmentRepo.save(appointmentDetail);
    }

    @Override
    public List<AppointmentBO> fetchAll() throws ParseException {

        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        List<Appointment> appointmentsTemp = appointmentRepo.findAll();
        List<Appointment> appointments = new ArrayList<>();
        if (null != appointmentsTemp) {
            for (Appointment obj : appointmentsTemp) {
                if (obj.getIsActive().equals(true)) {
                    appointments.add(obj);
                }
            }
        }
        List<AppointmentBO> appointmentBo = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (null != appointment.getAppointmentEndDate()
                && null != appointment.getAppointmentStartDate()) {
                AppointmentBO obj = new AppointmentBO();
                obj.setEnd(targetFormat
                        .parse(targetFormat.format(appointment.getAppointmentEndDate())));
                obj.setStart(targetFormat
                        .parse(targetFormat.format(appointment.getAppointmentStartDate())));
                obj.setTitle("Name:- " + appointment.getPatient().getFirstname() + " "
                             + appointment.getPatient().getLastname() + " , \t Phone:- "
                             + appointment.getPatient().getNumber());
                appointmentBo.add(obj);
            }
        }
        return appointmentBo;
    }

    @Override
    public List<AppointmentBO> fetchTodaysAppointment() throws ParseException {

        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        List<Appointment> appointmentsTemp =
                appointmentRepo.findByIsActiveTrueAndAppointmentStartDateBetween(
                        DateUtil.getCurrentStart(), DateUtil.getCurrentEnd());
        List<Appointment> appointments = new ArrayList<>();
        if (null != appointmentsTemp) {
            for (Appointment obj : appointmentsTemp) {
                if (obj.getIsActive().equals(true)) {
                    appointments.add(obj);
                }
            }
        }
        List<AppointmentBO> appointmentBo = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (null != appointment.getAppointmentEndDate()
                && null != appointment.getAppointmentStartDate()) {
                AppointmentBO obj = new AppointmentBO();
                obj.setEnd(targetFormat
                        .parse(targetFormat.format(appointment.getAppointmentEndDate())));
                obj.setStart(targetFormat
                        .parse(targetFormat.format(appointment.getAppointmentStartDate())));
                obj.setTitle("Name:- " + appointment.getPatient().getFirstname() + " "
                             + appointment.getPatient().getLastname() + " , \t Phone:- "
                             + appointment.getPatient().getNumber());
                appointmentBo.add(obj);
            }
        }
        return appointmentBo;
    }
}
