package com.vellechokre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.RecordVisit;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.services.VisitService;
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
@RequestMapping(value = "visit")
public class VisitController {

    @Autowired
    private VisitService service;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody(required = false) final RecordVisit recordVisit) {

        service.recordVisit(recordVisit);
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.OK.value(), "visit recorded successfully."),
                HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<SuccessResponse> getVisitsByPatientId(@PathVariable Integer patientId) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getVisitsByPatientId(patientId));
    }

    @GetMapping("/all")
    public ResponseEntity<SuccessResponse> fetchAll() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchAll());
    }
}
