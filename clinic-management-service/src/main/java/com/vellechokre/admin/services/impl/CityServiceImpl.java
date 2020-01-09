package com.vellechokre.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.CityService;
import com.vellechokre.entity.master.City;
import com.vellechokre.repository.master.CityRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo repo;

    @Override
    public City save(City city) {

        return repo.save(city);
    }

    @Override
    public List<City> fetchAll() {

        return repo.findAll();
    }

    @Override
    public List<City> getCityByStateId(Integer stateId) {

        return repo.findByStateId(stateId);
    }
}
