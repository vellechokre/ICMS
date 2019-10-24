package com.vellechokre.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.admin.services.AdminService;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.Branch;
import com.vellechokre.entity.Clinic;
import com.vellechokre.entity.LoginUser;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.ApplicationUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 17, 2019
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService service;

    /**
     * @param clinic
     * @return
     */
    @PostMapping(value = "create-clinic")
    public ResponseEntity<?> createClinic(@RequestBody Clinic clinic) {

        return ApplicationUtil.getResponseEntity("Clinic created successfully.",
                service.createClinic(clinic));
    }

    /**
     * @param branch
     * @return
     */
    @PostMapping(value = "create-branch")
    public ResponseEntity<?> createBranch(@RequestBody Branch branch) {

        return ApplicationUtil.getResponseEntity("Branch created successfully.",
                service.createBranch(branch));
    }

    /**
     * @param user
     * @return
     */
    @PostMapping(value = "create-user")
    public ResponseEntity<?> createUser(@RequestBody LoginUser user) {

        return ApplicationUtil.getResponseEntity("User created successfully.",
                service.createUser(user));
    }

    @GetMapping(value = "fetch-clinics")
    public ResponseEntity<SuccessResponse> getAllClinics() {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getAllClinic());
    }

    @GetMapping(value = "fetch-clinics/{clinicCode}")
    public ResponseEntity<SuccessResponse> getBranchsByClinic(@PathVariable String clinicCode) {

        return ApplicationUtil.getResponseEntity(ApplicationConstant.DATA_FETCH_SUCCESS,
                service.getBranchsByClinic(clinicCode));
    }
}
