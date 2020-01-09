package com.vellechokre.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.admin.services.CountryService;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.master.Country;
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
@RequestMapping(value = "countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @PostMapping
    public ResponseEntity<SuccessResponse> save(@RequestBody Country country) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_SAVE_SUCCESS,
                service.save(country));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse> fetchAll() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.fetchAll());
    }
}
