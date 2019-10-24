package com.vellechokre.entity.master;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.vellechokre.entity.Branch;
import com.vellechokre.entity.EntityContant;
import com.vellechokre.entity.base.BaseObjectWithId;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 20, 2019
 */
@Entity(name = EntityContant.SPECIALITY)
public class Speciality extends BaseObjectWithId {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Branch branch;

    @NotNull(message = "Speciality Name can't be null.")
    private String name;

    @NotNull(message = "Speciality Description can't be null.")
    private String description;

    /**
     * @return the branch
     */
    public Branch getBranch() {

        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(Branch branch) {

        this.branch = branch;
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
}
