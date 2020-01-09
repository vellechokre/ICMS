package com.vellechokre.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vellechokre.entity.Address;
import com.vellechokre.entity.Clinic;
import com.vellechokre.entity.base.BaseObjectWithId;
import com.vellechokre.entity.master.Speciality;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 29, 2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchBo extends BaseObjectWithId {

    private String code;

    private String name;

    @OneToOne(optional = true)
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

    @ManyToOne(optional = true)
    @JoinColumn(name = "clinic_details_t_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Clinic clinic;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE},
                mappedBy = "branchs")
    private Set<Speciality> specialities = new HashSet<>();

    /**
     * @return the code
     */
    public String getCode() {

        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {

        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {

        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {

        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {

        this.address = address;
    }

    /**
     * @return the clinic
     */
    public Clinic getClinic() {

        return clinic;
    }

    /**
     * @param clinic the clinic to set
     */
    public void setClinic(Clinic clinic) {

        this.clinic = clinic;
    }

    /**
     * @return the specialities
     */
    public Set<Speciality> getSpecialities() {

        return specialities;
    }

    /**
     * @param specialities the specialities to set
     */
    public void setSpecialities(Set<Speciality> specialities) {

        this.specialities = specialities;
    }
}
