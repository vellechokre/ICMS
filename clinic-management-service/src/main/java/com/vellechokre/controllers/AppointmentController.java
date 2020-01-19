package com.vellechokre.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.AppointmentBO;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.Appointment;
import com.vellechokre.services.AppointmentService;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.ApplicationUtil;

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
    private AppointmentService service;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> save(@RequestBody(required = false) final Appointment appointmentDetail) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.save(appointmentDetail));
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "fetchAll", method = RequestMethod.GET)
    public List<AppointmentBO> fetchAll() throws ParseException {

        return service.fetchAll();
    }
}
