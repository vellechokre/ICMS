package com.vellechokre.services;

import java.text.ParseException;
import java.util.List;

import com.vellechokre.bo.AppointmentBO;
import com.vellechokre.repository.projection.CategoryCountProjection;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 19, 2020
 */
public interface DashboardService {

    /**
     * @return
     * @throws ParseException
     */
    List<AppointmentBO> getTodaysAppointment() throws ParseException;

    /**
     * @return
     */
    long getTotalPatientVisited();

    /**
     * @return
     */
    long getPatientVisitedInLastWeek();

    /**
     * @return
     */
    List<CategoryCountProjection> getPatientByTreatmentType();
}
