package com.vellechokre.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.AppointmentBO;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.Appointment;
import com.vellechokre.repository.AppointmentRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@RestController
@RequestMapping(value = "appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody(required = false) final Appointment appointmentDetail) {

        Appointment appointmentsOld = appointmentRepo
                .findByPatientIdAndIsActiveTrue(appointmentDetail.getPatient().getId());
        if (null != appointmentsOld) {
            appointmentsOld.setIsActive(false);
            appointmentRepo.save(appointmentsOld);
        }
        appointmentRepo.save(appointmentDetail);
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.OK.value(), "Appointment added successfully."),
                HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "fetchAll", method = RequestMethod.GET)
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
}
