package com.vellechokre.services.impl;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vellechokre.bo.ErrorResponse;
import com.vellechokre.bo.PatientData;
import com.vellechokre.bo.SuccessResponse;
import com.vellechokre.entity.AddressDetails;
import com.vellechokre.entity.AppointmentDetail;
import com.vellechokre.entity.PatientDetail;
import com.vellechokre.repository.AddressDetailsRepo;
import com.vellechokre.repository.AppointmentDetailsRepo;
import com.vellechokre.repository.PatientDetailRepo;
import com.vellechokre.services.MailService;
import com.vellechokre.services.PatientService;
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
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDetailRepo patientRepo;

    @Autowired
    private AddressDetailsRepo addressRepo;

    @Autowired
    private MailService mailService;

    @Autowired
    private AppointmentDetailsRepo appointmentRepo;

    @Override
    public ResponseEntity createPatient(PatientData patientData) {

        final String response = validateSave(patientData);
        if (response.equals("SUCCESS")) {
            final PatientDetail patientDetail = patientRepo.save(patientData.getPatientDetail());
            final AddressDetails addressDetail = patientData.getAddressDetail();
            if (null != addressDetail) {
                addressDetail.setPatient(patientDetail);
                addressRepo.save(addressDetail);
            }
            if (patientDetail.isSendWelcomeMessage()) {
                if (!StringUtils.isEmpty(patientDetail.getNumber())) {
                    final Map<String, Object> params =
                            SmsUtil.buildParams(patientDetail.getNumber(), SmsUtil.buildSmsBody(
                                    patientDetail.getFirstname(), ApplicationConstant.WELCOME_SMS));
                    RestUtil.get(ApplicationConstant.BASE_URL_SMS, params);
                }
                if (!StringUtils.isEmpty(patientDetail.getEmailId())) {
                    mailService.sendWelcomeEmail(mailService.composeMail(patientDetail));
                }
            }
            if (patientDetail.isSendAddress()) {
                if (!StringUtils.isEmpty(patientDetail.getNumber())) {
                    final Map<String, Object> params =
                            SmsUtil.buildParams(patientDetail.getNumber(), SmsUtil.buildSmsBody(
                                    patientDetail.getFirstname(), ApplicationConstant.ADDRESS_SMS));
                    RestUtil.get(ApplicationConstant.BASE_URL_SMS, params);
                }
                if (!StringUtils.isEmpty(patientDetail.getEmailId())) {
                    mailService.sendAddressEmail(mailService.composeMail(patientDetail));
                }
            }
            return new ResponseEntity<>(
                    new SuccessResponse(HttpStatus.OK.value(), "Patient added successfully."),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.value(), response),
                    HttpStatus.OK);
        }
    }

    private String validateSave(PatientData patientData) {

        if (null == patientData) {
            return "Data can't be null.";
        }
        if (null == patientData.getPatientDetail()) {
            return "Data can't be null.";
        }
        // if (null == patientData.getAddressDetail()) {
        // return "Data can't be null.";
        // }
        return "SUCCESS";
    }

    /*
     * (non-Javadoc)
     *
     * @see com.dev.service.PatientService#saveDetail(com.dev.bo.PatientData)
     */
    @Override
    public ResponseEntity saveDetail(PatientData patientData) {

        final String response = validateSave(patientData);
        if (response.equals("SUCCESS")) {
            final PatientDetail patientDetail = patientData.getPatientDetail();
            final PatientDetail patientDetailUpdated = patientRepo.save(patientDetail);
            final AppointmentDetail appointmentDetail = patientData.getAppointmentDetail();
            if (null != appointmentDetail) {
                appointmentDetail.setPatient(patientDetailUpdated);
                appointmentRepo.save(appointmentDetail);
            }
            final AddressDetails addressDetail = patientData.getAddressDetail();
            final AddressDetails address =
                    addressRepo.findByPatientId(patientDetailUpdated.getId());
            if (null != addressDetail) {
                if (null != address) {
                    BeanUtils.copyProperties(addressDetail, address);
                }
                addressDetail.setPatient(patientDetailUpdated);
                addressRepo.save(addressDetail);
            }
            if (patientDetail.isSendAddress() && !StringUtils.isEmpty(patientDetail.getEmailId())) {
                mailService.sendAddressEmail(mailService.composeMail(patientDetail));
            }
            if (patientDetail.isSendWelcomeMessage()
                && !StringUtils.isEmpty(patientDetail.getEmailId())) {
                mailService.sendWelcomeEmail(mailService.composeMail(patientDetail));
            }
            return new ResponseEntity<>(
                    new SuccessResponse(HttpStatus.OK.value(), "Patient data saved successfully."),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.value(), response),
                    HttpStatus.OK);
        }
    }

    @Override
    public PatientData findById(Integer id) {

        System.out.println("inside getPatientByFirstName:::::::" + id);
        final PatientData patientData = new PatientData();
        patientData.setAddressDetail(addressRepo.findByPatientId(id));
        patientData.setAppointmentDetail(appointmentRepo.findByPatientIdAndIsActiveTrue(id));
        patientData.setPatientDetail(patientRepo.findById(id).get());
        return patientData;
    }
}
