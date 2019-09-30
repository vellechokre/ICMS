package com.vellechokre.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.EmailDetails;
import com.vellechokre.repository.EmailDetailsRepo;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@RestController
@RequestMapping(value = "configure")
public class ConfigController {

    @Autowired
    private EmailDetailsRepo emailRepo;

    // http://localhost:9000/configure/email
    // {
    // "host":"smtp.mail.yahoo.com",
    // "port":"465",
    // "username":"devdentalclinic",
    // "password":"parth0990"
    // }
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "email", method = RequestMethod.POST)
    public ResponseEntity email(@RequestBody final EmailDetails emailDetails) {

        emailRepo.save(emailDetails);
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.OK.value(), "Email Detiail added successfully."),
                HttpStatus.OK);
    }

    @RequestMapping(value = "findIp", method = RequestMethod.GET)
    public String getIp() {

        String ipAddress = null;
        try {
            InetAddress ipAddr = InetAddress.getLocalHost();
            System.out.println(ipAddr.getHostAddress());
            ipAddress = ipAddr.getHostAddress();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        return ipAddress;
    }
}
