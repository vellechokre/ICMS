package com.vellechokre.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.admin.services.DistrictService;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.master.District;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.ApplicationUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
@RestController
@RequestMapping(value = "districts")
public class DistrictController {

    @Autowired
    private DistrictService service;

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody District district) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.save(district));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> fetchAll() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchAll());
    }

    @GetMapping("/byStateId")
    public ResponseEntity<SuccessResponse> getDistrictByStateId(@RequestParam Integer stateId) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getDistrictByStateId(stateId));
    }
}
