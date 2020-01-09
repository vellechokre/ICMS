package com.vellechokre.geonames.services;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Dec 1, 2019
 */
public interface GeoService {

    /**
     *
     */
    void fetchCountry();

    /**
     *
     */
    void fetchStates();

    /**
     *
     */
    void fetchDistricts();

    /**
     *
     */
    void fetchCities();
}
