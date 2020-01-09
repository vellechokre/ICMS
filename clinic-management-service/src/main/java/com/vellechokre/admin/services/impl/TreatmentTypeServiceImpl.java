package com.vellechokre.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.TreatmentTypeService;
import com.vellechokre.entity.master.TreatmentType;
import com.vellechokre.repository.master.TreatmentTypeRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 3, 2020
 */
@Service
public class TreatmentTypeServiceImpl implements TreatmentTypeService {

    @Autowired
    private TreatmentTypeRepo repo;

    @Override
    public TreatmentType save(TreatmentType treatmentType) {

        return repo.save(treatmentType);
    }

    @Override
    public List<TreatmentType> fetchAll() {

        return repo.findAll();
    }
}
