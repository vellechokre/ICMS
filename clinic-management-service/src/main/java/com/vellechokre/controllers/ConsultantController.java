package com.vellechokre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.ConsultantDetail;
import com.vellechokre.repository.ConsultantDetailsRepo;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Controller
@RequestMapping(value = "consultant")
public class ConsultantController {

    @Autowired
    private ConsultantDetailsRepo consultantRepo;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody final ConsultantDetail consultantDetail) {

        consultantRepo.save(consultantDetail);
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.OK.value(), "Consultant added successfully."),
                HttpStatus.OK);
    }
}
