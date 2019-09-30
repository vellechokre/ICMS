package com.vellechokre.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vellechokre.entity.base.BaseObject;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = EntityContant.ADDRESS_DETAIL_T)
public class AddressDetails extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientDetail patient;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "street")
    private String street;

    /**
     * @return the id
     */
    public Integer getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {

        this.id = id;
    }

    /**
     * @return the patient
     */
    public PatientDetail getPatient() {

        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(final PatientDetail patient) {

        this.patient = patient;
    }

    /**
     * @return the country
     */
    public String getCountry() {

        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(final String country) {

        this.country = country;
    }

    /**
     * @return the state
     */
    public String getState() {

        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(final String state) {

        this.state = state;
    }

    /**
     * @return the city
     */
    public String getCity() {

        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(final String city) {

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
    public void setPincode(final String pincode) {

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
    public void setStreet(final String street) {

        this.street = street;
    }
}
