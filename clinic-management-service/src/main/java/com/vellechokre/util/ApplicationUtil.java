package com.vellechokre.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.vellechokre.bo.SuccessResponse;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 17, 2019
 */
public class ApplicationUtil {

    public static ResponseEntity<SuccessResponse> getResponseEntity(String message) {

        return new ResponseEntity<>(new SuccessResponse(HttpStatus.OK.value(), message),
                HttpStatus.OK);
    }

    public static ResponseEntity<SuccessResponse> getResponseEntity(String message, Object data) {

        return new ResponseEntity<>(new SuccessResponse(HttpStatus.OK.value(), message, data),
                HttpStatus.OK);
    }
}
