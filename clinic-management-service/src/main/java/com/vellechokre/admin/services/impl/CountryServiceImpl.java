package com.vellechokre.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.CountryService;
import com.vellechokre.entity.master.Country;
import com.vellechokre.repository.master.CountryRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo repo;

    @Override
    public Country save(Country country) {

        return repo.save(country);
    }

    @Override
    public List<Country> fetchAll() {

        return repo.findAll();
    }
}
