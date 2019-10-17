package com.vellechokre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.entity.Patient;
import com.vellechokre.services.CommuncationService;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@RestController
public class CommunicationController {

    @Autowired
    private CommuncationService service;

    @RequestMapping(value = "sendSms", method = RequestMethod.POST)
    public ResponseEntity sendSms(@RequestBody final List<Patient> patients,
                                  @RequestParam String message) {

        return service.sendSms(patients, message);
    }
}
