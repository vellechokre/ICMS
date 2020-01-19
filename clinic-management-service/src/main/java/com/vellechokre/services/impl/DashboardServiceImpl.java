package com.vellechokre.services.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.bo.AppointmentBO;
import com.vellechokre.repository.projection.CategoryCountProjection;
import com.vellechokre.services.AppointmentService;
import com.vellechokre.services.DashboardService;
import com.vellechokre.services.PatientService;
import com.vellechokre.services.VisitService;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 19, 2020
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitService visitService;

    @Override
    public List<AppointmentBO> getTodaysAppointment() throws ParseException {

        return appointmentService.fetchTodaysAppointment();
    }

    @Override
    public long getTotalPatientVisited() {

        return patientService.getTotalPatientVisited();
    }

    @Override
    public long getPatientVisitedInLastWeek() {

        return visitService.getPatientVisitedInLastWeek();
    }

    @Override
    public List<CategoryCountProjection> getPatientByTreatmentType() {

        List<CategoryCountProjection> result = visitService.getPatientByTreatmentType();
        return visitService.getPatientByTreatmentType();
    }
}
