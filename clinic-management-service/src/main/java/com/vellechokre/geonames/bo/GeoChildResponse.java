package com.vellechokre.geonames.bo;

import java.util.ArrayList;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Dec 1, 2019
 */
public class GeoChildResponse {

    private float totalResultsCount;

    ArrayList<GeoChild> geonames = new ArrayList<>();

    // Getter Methods
    public float getTotalResultsCount() {

        return totalResultsCount;
    }

    // Setter Methods
    public void setTotalResultsCount(float totalResultsCount) {

        this.totalResultsCount = totalResultsCount;
    }

    /**
     * @return the geonames
     */
    public ArrayList<GeoChild> getGeonames() {

        return geonames;
    }

    /**
     * @param geonames the geonames to set
     */
    public void setGeonames(ArrayList<GeoChild> geonames) {

        this.geonames = geonames;
    }
}
