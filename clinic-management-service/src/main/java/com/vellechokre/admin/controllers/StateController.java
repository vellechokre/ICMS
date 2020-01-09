package com.vellechokre.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.admin.services.StateService;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.master.State;
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
@RequestMapping(value = "states")
public class StateController {

    @Autowired
    private StateService service;

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody State state) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.save(state));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> fetchAll() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchAll());
    }

    @GetMapping("/byCountryId")
    public ResponseEntity<SuccessResponse> getStateByCountry(@RequestParam Integer countryId) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getStateByCountry(countryId));
    }
}
