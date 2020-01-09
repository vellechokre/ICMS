package com.vellechokre.admin.services;

import java.util.List;

import com.vellechokre.entity.master.TreatmentType;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 3, 2020
 */
public interface TreatmentTypeService {

    TreatmentType save(TreatmentType treatmentType);

    /**
     * @return
     */
    List<TreatmentType> fetchAll();
}
