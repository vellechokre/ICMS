package com.vellechokre.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Aug 28, 2019
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping()
    public String testApplication() {

        return "Success";
    }
}
