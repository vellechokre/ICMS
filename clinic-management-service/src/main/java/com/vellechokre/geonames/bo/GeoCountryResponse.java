package com.vellechokre.geonames.bo;

import java.util.ArrayList;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Dec 1, 2019
 */
public class GeoCountryResponse {

    ArrayList<GeoCountry> geonames;

    /**
     * @return the geonames
     */
    public ArrayList<GeoCountry> getGeonames() {

        return geonames;
    }

    /**
     * @param geonames the geonames to set
     */
    public void setGeonames(ArrayList<GeoCountry> geonames) {

        this.geonames = geonames;
    }
}
