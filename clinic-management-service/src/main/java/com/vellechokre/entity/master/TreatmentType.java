package com.vellechokre.entity.master;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vellechokre.entity.EntityContant;
import com.vellechokre.entity.base.BaseObjectWithId;

/***
 * Project clinic-management-service**
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = EntityContant.TREATMENT_TYPE)
public class TreatmentType extends BaseObjectWithId {

    private String description;

    @ManyToOne
    @JoinColumn(name = "specialityId")
    private Speciality speciality;

    /**
     * @return the description
     */
    public String getDescription() {

        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {

        this.description = description;
    }

    /**
     * @return the speciality
     */
    public Speciality getSpeciality() {

        return speciality;
    }

    /**
     * @param speciality the speciality to set
     */
    public void setSpeciality(Speciality speciality) {

        this.speciality = speciality;
    }
}
