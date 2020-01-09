package com.vellechokre.geonames.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.geonames.services.GeoService;
import com.vellechokre.util.ApplicationUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Dec 1, 2019
 */
@RestController
@RequestMapping("geo-apis")
public class GeoController {

    @Autowired
    private GeoService service;

    @GetMapping("countries")
    public ResponseEntity<SuccessResponse> getCountries() {

        service.fetchCountry();
        return ApplicationUtil.getResponseEntity("Country fetched successfully.");
    }

    @GetMapping("states")
    public ResponseEntity<SuccessResponse> getStates() {

        service.fetchStates();
        return ApplicationUtil.getResponseEntity("States fetched successfully.");
    }

    @GetMapping("districts")
    public ResponseEntity<SuccessResponse> getDistricts() {

        service.fetchDistricts();
        return ApplicationUtil.getResponseEntity("Districts fetched successfully.");
    }

    @GetMapping("cities")
    public ResponseEntity<SuccessResponse> getCities() {

        service.fetchCities();
        return ApplicationUtil.getResponseEntity("Cities fetched successfully.");
    }
}
