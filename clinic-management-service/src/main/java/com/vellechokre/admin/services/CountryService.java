package com.vellechokre.admin.services;

import java.util.List;

import com.vellechokre.entity.master.Country;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
public interface CountryService {

    /**
     * @param country
     * @return
     */
    Country save(Country country);

    /**
     * @return
     */
    List<Country> fetchAll();
}
