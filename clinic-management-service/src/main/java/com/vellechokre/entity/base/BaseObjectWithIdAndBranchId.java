package com.vellechokre.entity.base;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Project clinic-management-service
 *
 *te Sep 2, 2019
 */
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class BaseObjectWithIdAndBranchId extends BaseObjectWithId {

    @Column(name = "branch_id")
    @NotNull(message = "Branch Id can't be null")
    private Integer branchId;

    /**
     * @return the branchId
     */
    public Integer getBranchId() {

        return branchId;
    }

    /**
     * @param branchId the branchId to set
     */
    public void setBranchId(Integer branchId) {

        this.branchId = branchId;
    }
}
