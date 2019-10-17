package com.vellechokre.entity.master;

import java.math.BigDecimal;

import javax.persistence.Entity;

import com.vellechokre.entity.EntityContant;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
@Entity(name = EntityContant.COUNTRY)
public class Country extends AbstractLocation {

    private BigDecimal areaInSqKm;

    private String continentName;

    private String currencyCode;

    /**
     * @return the areaInSqKm
     */
    public BigDecimal getAreaInSqKm() {

        return areaInSqKm;
    }

    /**
     * @param areaInSqKm the areaInSqKm to set
     */
    public void setAreaInSqKm(BigDecimal areaInSqKm) {

        this.areaInSqKm = areaInSqKm;
    }

    /**
     * @return the continentName
     */
    public String getContinentName() {

        return continentName;
    }

    /**
     * @param continentName the continentName to set
     */
    public void setContinentName(String continentName) {

        this.continentName = continentName;
    }

    /**
     * @return the currencyCode
     */
    public String getCurrencyCode() {

        return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(String currencyCode) {

        this.currencyCode = currencyCode;
    }
}
