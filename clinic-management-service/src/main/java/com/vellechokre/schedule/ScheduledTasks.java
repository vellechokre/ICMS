package com.vellechokre.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.vellechokre.entity.Appointment;
import com.vellechokre.entity.Patient;
import com.vellechokre.repository.AppointmentRepo;
import com.vellechokre.repository.PatientRepo;
import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.DateUtil;
import com.vellechokre.util.RestUtil;
import com.vellechokre.util.SmsUtil;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Scheduled(cron = "0 15 10 * * ?")
    public void oneDayBeforeReminder() {

        Calendar calendar = Calendar.getInstance();
        DateUtil.toBeginningOfTheDay(calendar);
        final Date startDate = calendar.getTime();
        calendar = Calendar.getInstance();
        DateUtil.toEndOfTheDay(calendar);
        final Date endDate = calendar.getTime();
        final Calendar calNext = Calendar.getInstance();
        calNext.add(Calendar.DATE, 1);
        final List<Appointment> appointments = appointmentRepo
                .findByIsActiveTrueAndAppointmentStartDateBetween(startDate, endDate);
        appointments.forEach(appointment -> {
            if (!StringUtils.isEmpty(appointment.getPatient().getNumber())) {
                final Map<String, Object> params =
                        SmsUtil.buildParams(appointment.getPatient().getNumber(),
                                SmsUtil.buildSmsBody(appointment.getPatient().getFirstname(),
                                        ApplicationConstant.APPOINTMENT_REMINDER_SMS));
                RestUtil.get(ApplicationConstant.BASE_URL_SMS, params);
            }
        });
        logger.debug("Cron Task :: Execution Time - {}", new Date());
    }

    @Scheduled(cron = "0 10 10 * * ?")
    public void birthDayWishes() {

        logger.debug("Cron Task :: Execution Time - {}", new Date());
        Calendar calendar = Calendar.getInstance();
        DateUtil.toBeginningOfTheDay(calendar);
        final Date startDate = calendar.getTime();
        calendar = Calendar.getInstance();
        DateUtil.toEndOfTheDay(calendar);
        final Date endDate = calendar.getTime();
        final List<Patient> patients =
                patientRepo.findByIsActiveTrueAndDobBetween(startDate, endDate);
        patients.forEach(patient -> {
            if (!StringUtils.isEmpty(patient.getNumber())) {
                final Map<String, Object> params =
                        SmsUtil.buildParams(patient.getNumber(), SmsUtil.buildSmsBody(
                                patient.getFirstname(), ApplicationConstant.BIRTHDAY_WISH_SMS));
                RestUtil.get(ApplicationConstant.BASE_URL_SMS, params);
            }
        });
    }
}
