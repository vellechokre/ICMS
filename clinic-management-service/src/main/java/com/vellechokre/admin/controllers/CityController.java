package com.vellechokre.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.admin.services.CityService;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.master.City;
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
@RequestMapping(value = "cities")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody City city) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.save(city));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> fetchAll() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchAll());
    }

    @GetMapping("/byStateId")
    public ResponseEntity<SuccessResponse> getCityByDistrictId(@RequestParam Integer stateId) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getCityByStateId(stateId));
    }
}
