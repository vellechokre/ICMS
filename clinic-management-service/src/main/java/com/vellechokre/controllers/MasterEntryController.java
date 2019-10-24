package com.vellechokre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.entity.Treatment;
import com.vellechokre.repository.TreatmentRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@RestController
public class MasterEntryController {

    @Autowired
    private TreatmentRepo treatmentRepo;

    @RequestMapping(value = "/treatment/save", method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody final Treatment treatment) {

        treatmentRepo.save(treatment);
    }
}
