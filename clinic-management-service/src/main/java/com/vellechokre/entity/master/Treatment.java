package com.vellechokre.entity.master;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.vellechokre.entity.EntityContant;
import com.vellechokre.entity.base.BaseObjectWithId;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 20, 2019
 */
@Entity(name = EntityContant.TREATMENT)
public class Treatment extends BaseObjectWithId {

    @NotNull(message = "Treatment Name can't be null.")
    private String name;

    @NotNull(message = "Treatment Description can't be null.")
    private String desc;

    @NotNull(message = "Speciality Id can't be null.")
    private Integer specialityId;

    @NotNull(message = "Parent Treatment Id can't be null.")
    private Integer parentTreatmentId;

    private Integer charge = 0;

    private Boolean hasChild;

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
     * @return the desc
     */
    public String getDesc() {

        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {

        this.desc = desc;
    }

    /**
     * @return the specialityId
     */
    public Integer getSpecialityId() {

        return specialityId;
    }

    /**
     * @param specialityId the specialityId to set
     */
    public void setSpecialityId(Integer specialityId) {

        this.specialityId = specialityId;
    }

    /**
     * @return the parentTreatmentId
     */
    public Integer getParentTreatmentId() {

        return parentTreatmentId;
    }

    /**
     * @param parentTreatmentId the parentTreatmentId to set
     */
    public void setParentTreatmentId(Integer parentTreatmentId) {

        this.parentTreatmentId = parentTreatmentId;
    }

    /**
     * @return the charge
     */
    public Integer getCharge() {

        return charge;
    }

    /**
     * @param charge the charge to set
     */
    public void setCharge(Integer charge) {

        this.charge = charge;
    }

    /**
     * @return the hasChild
     */
    public Boolean getHasChild() {

        return hasChild;
    }

    /**
     * @param hasChild the hasChild to set
     */
    public void setHasChild(Boolean hasChild) {

        this.hasChild = hasChild;
    }
}
