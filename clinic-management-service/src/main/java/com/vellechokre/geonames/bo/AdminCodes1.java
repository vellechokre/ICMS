package com.vellechokre.geonames.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Dec 1, 2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminCodes1 {

    private String ISO3166_2;

    // Getter Methods
    public String getISO3166_2() {

        return ISO3166_2;
    }

    // Setter Methods
    public void setISO3166_2(String ISO3166_2) {

        this.ISO3166_2 = ISO3166_2;
    }
}
