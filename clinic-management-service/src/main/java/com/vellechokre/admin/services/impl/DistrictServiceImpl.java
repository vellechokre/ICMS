package com.vellechokre.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.DistrictService;
import com.vellechokre.entity.master.District;
import com.vellechokre.repository.master.DistrictRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepo repo;

    @Override
    public District save(District district) {

        return repo.save(district);
    }

    @Override
    public List<District> fetchAll() {

        return repo.findAll();
    }

    @Override
    public List<District> getDistrictByStateId(Integer stateId) {

        return repo.findByStateId(stateId);
    }
}
