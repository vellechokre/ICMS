package com.vellechokre.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.PatientDetail;
import com.vellechokre.services.CommuncationService;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.RestUtil;
import com.vellechokre.util.SmsUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Service
public class CommunicationServiceImpl implements CommuncationService {

    @Override
    public ResponseEntity sendSms(List<PatientDetail> patients, String message) {

        patients.forEach(patient -> {
            if (!StringUtils.isEmpty(patient.getNumber())) {
                final Map<String, Object> params =
                        SmsUtil.buildParams(patient.getNumber(), message);
                RestUtil.get(ApplicationConstant.BASE_URL_SMS, params);
            }
        });
        return new ResponseEntity<>(
                new SuccessResponse(HttpStatus.OK.value(), "SMS sent successfully."),
                HttpStatus.OK);
    }
}
