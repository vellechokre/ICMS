package com.vellechokre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.vellechokre.entity.base.BaseObjectWithIdAndBranchId;
import com.vellechokre.entity.master.City;
import com.vellechokre.entity.master.Country;
import com.vellechokre.entity.master.District;
import com.vellechokre.entity.master.State;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = EntityContant.ADDRESS)
public class Address extends BaseObjectWithIdAndBranchId {

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "country_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "state_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "district_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private District district;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "city_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "street")
    private String street;

    /**
     * @return the patient
     */
    public Patient getPatient() {

        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {

        this.patient = patient;
    }

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

    /**
     * @return the city
     */
    public City getCity() {

        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(City city) {

        this.city = city;
    }

    /**
     * @return the pincode
     */
    public String getPincode() {

        return pincode;
    }

    /**
     * @param pincode the pincode to set
     */
    public void setPincode(String pincode) {

        this.pincode = pincode;
    }

    /**
     * @return the street
     */
    public String getStreet() {

        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {

        this.street = street;
    }
}
