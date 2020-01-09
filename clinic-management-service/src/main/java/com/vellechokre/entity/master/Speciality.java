package com.vellechokre.entity.master;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "speciality_branch", joinColumns = {@JoinColumn(name = "speciality_id")},
               inverseJoinColumns = {@JoinColumn(name = "branch_id")})
    private Set<Branch> branchs = new HashSet<>();

    @NotNull(message = "Speciality Name can't be null.")
    private String name;

    @NotNull(message = "Speciality Description can't be null.")
    private String description;

    /**
     * @return the branchs
     */
    public Set<Branch> getBranchs() {

        return branchs;
    }

    /**
     * @param branchs the branchs to set
     */
    public void setBranchs(Set<Branch> branchs) {

        this.branchs = branchs;
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
