package com.vellechokre.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.entity.master.Speciality;
import com.vellechokre.repository.master.SpecialityRepo;
import com.vellechokre.services.SpecialityService;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 24, 2019
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepo repo;

    @Override
    public Speciality create(Speciality speciality) {

        return repo.save(speciality);
    }
}
