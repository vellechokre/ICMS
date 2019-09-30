package com.vellechokre.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.ErrorResponse;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.UserLogin;
import com.vellechokre.repository.UserLoginRepo;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@RestController
@RequestMapping(path = "/user")
public class WelcomeController {

    @Autowired
    private UserLoginRepo loginRepo;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "authenticate", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody final UserLogin userLogin) {

        System.out.println("inside login " + userLogin.getUserName() + " user password "
                           + userLogin.getPassword());
        final UserLogin userDetail = loginRepo.findByUserNameAndPassword(userLogin.getUserName(),
                userLogin.getPassword());
        if (Objects.isNull(userDetail)) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                    "UserName or password is incorrect."), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    new SuccessResponse(HttpStatus.OK.value(), "Welcome to Dev Clinic"),
                    HttpStatus.OK);
        }
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> saveCredential(@RequestBody final UserLogin userLogin) {

        loginRepo.save(userLogin);
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.OK.value(), "User added successfully."),
                HttpStatus.OK);
    }
}
