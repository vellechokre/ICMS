package com.vellechokre.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.admin.services.TreatmentCategoryService;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.master.TreatmentCategory;
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
@RequestMapping(value = "treatmentCategories")
public class TreatmentCategoryController {

    @Autowired
    private TreatmentCategoryService service;

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody TreatmentCategory treatmentCategory) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.save(treatmentCategory));
    }

    @PutMapping
    public ResponseEntity<SuccessResponse> update(@RequestBody TreatmentCategory treatmentCategory) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.update(treatmentCategory));
    }

    @GetMapping("{treatmentTypeId}")
    public ResponseEntity<SuccessResponse> fetchByTreatmentType(@PathVariable Integer treatmentTypeId) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchByTreatmentType(treatmentTypeId));
    }

    @GetMapping("all")
    public ResponseEntity<SuccessResponse> fetchAll() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchAll());
    }
}
