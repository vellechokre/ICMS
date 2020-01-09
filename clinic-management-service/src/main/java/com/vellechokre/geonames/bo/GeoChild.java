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
public class GeoChild {

    private String adminCode1;

    private String lng;

    private float geonameId;

    private String toponymName;

    private String countryId;

    private String fcl;

    private float population;

    private String countryCode;

    private String name;

    private String fclName;

    AdminCodes1 AdminCodes1Object;

    private String countryName;

    private String fcodeName;

    private String adminName1;

    private String lat;

    private String fcode;

    // Getter Methods
    public String getAdminCode1() {

        return adminCode1;
    }

    public String getLng() {

        return lng;
    }

    public float getGeonameId() {

        return geonameId;
    }

    public String getToponymName() {

        return toponymName;
    }

    public String getCountryId() {

        return countryId;
    }

    public String getFcl() {

        return fcl;
    }

    public float getPopulation() {

        return population;
    }

    public String getCountryCode() {

        return countryCode;
    }

    public String getName() {

        return name;
    }

    public String getFclName() {

        return fclName;
    }

    public AdminCodes1 getAdminCodes1() {

        return AdminCodes1Object;
    }

    public String getCountryName() {

        return countryName;
    }

    public String getFcodeName() {

        return fcodeName;
    }

    public String getAdminName1() {

        return adminName1;
    }

    public String getLat() {

        return lat;
    }

    public String getFcode() {

        return fcode;
    }

    // Setter Methods
    public void setAdminCode1(String adminCode1) {

        this.adminCode1 = adminCode1;
    }

    public void setLng(String lng) {

        this.lng = lng;
    }

    public void setGeonameId(float geonameId) {

        this.geonameId = geonameId;
    }

    public void setToponymName(String toponymName) {

        this.toponymName = toponymName;
    }

    public void setCountryId(String countryId) {

        this.countryId = countryId;
    }

    public void setFcl(String fcl) {

        this.fcl = fcl;
    }

    public void setPopulation(float population) {

        this.population = population;
    }

    public void setCountryCode(String countryCode) {

        this.countryCode = countryCode;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setFclName(String fclName) {

        this.fclName = fclName;
    }

    public void setAdminCodes1(AdminCodes1 adminCodes1Object) {

        AdminCodes1Object = adminCodes1Object;
    }

    public void setCountryName(String countryName) {

        this.countryName = countryName;
    }

    public void setFcodeName(String fcodeName) {

        this.fcodeName = fcodeName;
    }

    public void setAdminName1(String adminName1) {

        this.adminName1 = adminName1;
    }

    public void setLat(String lat) {

        this.lat = lat;
    }

    public void setFcode(String fcode) {

        this.fcode = fcode;
    }
}
