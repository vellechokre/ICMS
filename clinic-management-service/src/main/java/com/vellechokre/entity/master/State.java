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
@Entity(name = EntityContant.STATE)
public class State extends AbstractLocation {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

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
}
