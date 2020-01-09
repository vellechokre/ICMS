package com.vellechokre.admin.services;

import java.util.List;

import com.vellechokre.entity.master.City;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
public interface CityService {

    /**
     * @param city
     * @return
     */
    City save(City city);

    /**
     * @return
     */
    List<City> fetchAll();

    /**
     * @param districtId
     * @return
     */
    List<City> getCityByStateId(Integer stateId);
}
