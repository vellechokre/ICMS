package com.vellechokre.services;

import java.util.List;

import com.vellechokre.bo.RecordVisit;
import com.vellechokre.entity.Visit;
import com.vellechokre.repository.projection.CategoryCountProjection;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface VisitService {

    void recordVisit(RecordVisit recordVisit);

    /**
     * @return
     */
    long getPatientVisitedInLastWeek();

    /**
     * @return
     */
    List<CategoryCountProjection> getPatientByTreatmentType();

    /**
     * @param patientId
     * @return
     */
    List<Visit> getVisitsByPatientId(Integer patientId);

    /**
     * @return
     */
    List<Visit> fetchAll();
}
