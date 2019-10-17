package com.vellechokre.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.PatientData;
import com.vellechokre.entity.Patient;
import com.vellechokre.repository.PatientRepo;
import com.vellechokre.services.PatientService;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@RestController
@RequestMapping(value = "patient")
public class PatientController {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private PatientService service;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody(required = false) final PatientData patientData) {

        return service.createPatient(patientData);
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "saveDetails", method = RequestMethod.POST)
    public ResponseEntity saveDetails(@RequestBody final PatientData patientData) {

        return service.saveDetail(patientData);
    }

    @RequestMapping(value = "/getPatientByName", method = RequestMethod.GET)
    public @ResponseBody List<Patient> getPatientByName(@RequestParam final String firstName) {

        return simulateSearchResult(firstName);
    }

    private List<Patient> simulateSearchResult(final String name) {

        final List<Patient> result = new ArrayList<>();
        // iterate a list and filter by tagName
        for (final Patient tag : patientRepo.findAll()) {
            if (!StringUtils.isEmpty(tag.getFirstname()) && tag.getFirstname().contains(name)) {
                result.add(tag);
            }
        }
        return result;
    }

    @RequestMapping(value = "/byId", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PatientData getPatientById(@RequestParam final Integer id) {

        return service.findById(id);
    }
    // @RequestMapping(value = "/findAllTreatmentCategory", method = RequestMethod.GET)
    // public ModelAndView findAllTreatmentCategory(
    // @ModelAttribute("treatmentCategory") final TreatmentCategory treatmentCategory) {
    //
    // System.out.println("inside reviewLead:::::::");
    // final List<TreatmentCategory> categories = treatmentCategoryRepo.findAll();
    // return new ModelAndView("reviewLead", "categories", categories);
    // }
}
