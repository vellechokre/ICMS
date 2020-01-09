package com.vellechokre.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.admin.services.TreatmentTypeService;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.master.TreatmentType;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.ApplicationUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 3, 2020
 */
@RestController
@RequestMapping(value = "treatmentTypes")
public class TreatmentTypeController {

    @Autowired
    private TreatmentTypeService service;

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody TreatmentType treatmentType) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.save(treatmentType));
    }

    @GetMapping("all")
    public ResponseEntity<SuccessResponse> fetchAll() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchAll());
    }
}
