package com.vellechokre.entity.master;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.vellechokre.entity.EntityContant;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
@Entity(name = EntityContant.CITY)
public class City extends AbstractLocation {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "state_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private District district;

    /**
     * @return the country
     */
    public Country getCountry() {

        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {

        this.country = country;
    }

    /**
     * @return the state
     */
    public State getState() {

        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(State state) {

        this.state = state;
    }

    /**
     * @return the district
     */
    public District getDistrict() {

        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(District district) {

        this.district = district;
    }
}
