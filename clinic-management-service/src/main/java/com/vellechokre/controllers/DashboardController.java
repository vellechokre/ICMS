package com.vellechokre.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.services.DashboardService;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.ApplicationUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 19, 2020
 */
@RestController
@RequestMapping(value = "dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @GetMapping("patient-by-treatmentType")
    public ResponseEntity<SuccessResponse> getPatientByTreatmentType() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getPatientByTreatmentType());
    }

    @GetMapping("total-patient-visited")
    public ResponseEntity<SuccessResponse> getTotalPatientVisited() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getTotalPatientVisited());
    }

    @GetMapping("patient-visited-week")
    public ResponseEntity<SuccessResponse> getPatientVisitedInLastWeek() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getPatientVisitedInLastWeek());
    }

    @GetMapping("todays-appointment")
    public ResponseEntity<SuccessResponse> getTodaysAppointment() throws ParseException {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getTodaysAppointment());
    }
}
