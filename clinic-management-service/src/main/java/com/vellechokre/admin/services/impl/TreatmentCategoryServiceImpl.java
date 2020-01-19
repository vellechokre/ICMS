package com.vellechokre.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.TreatmentCategoryService;
import com.vellechokre.entity.master.TreatmentCategory;
import com.vellechokre.repository.master.TreatmentCategoryRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 3, 2020
 */
@Service
public class TreatmentCategoryServiceImpl implements TreatmentCategoryService {

    @Autowired
    private TreatmentCategoryRepo repo;

    @Override
    public TreatmentCategory save(TreatmentCategory treatmentCategory) {

        return repo.save(treatmentCategory);
    }

    @Override
    public List<TreatmentCategory> fetchByTreatmentType(Integer treatmentTypeId) {

        return repo.findByTreatmentTypeId(treatmentTypeId);
    }

    @Override
    public TreatmentCategory update(TreatmentCategory treatmentCategory) {

        return repo.save(treatmentCategory);
    }

    @Override
    public List<TreatmentCategory> fetchAll() {

        return repo.findAll();
    }
}
