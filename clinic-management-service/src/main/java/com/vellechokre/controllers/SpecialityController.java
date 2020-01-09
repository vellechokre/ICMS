package com.vellechokre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.master.Speciality;
import com.vellechokre.services.SpecialityService;
import com.vellechokre.util.ApplicationUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 24, 2019
 */
@RestController
@RequestMapping(value = "specialities")
public class SpecialityController {

    @Autowired
    private SpecialityService service;

    @PostMapping
    public ResponseEntity<SuccessResponse> create(@RequestBody Speciality speciality) {

        return ApplicationUtil.getResponseEntity("Speciality Created successfully.",
                service.create(speciality));
    }
}
