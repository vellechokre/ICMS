package com.vellechokre.admin.services;

import java.util.List;

import com.vellechokre.entity.master.TreatmentCategory;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 3, 2020
 */
public interface TreatmentCategoryService {

    TreatmentCategory save(TreatmentCategory treatmentCategory);

    /**
     * @param treatmentTypeId
     * @return
     */
    List<TreatmentCategory> fetchByTreatmentType(Integer treatmentTypeId);

    /**
     * @param treatmentCategory
     * @return
     */
    TreatmentCategory update(TreatmentCategory treatmentCategory);

    /**
     * @return
     */
    List<TreatmentCategory> fetchAll();
}
