package com.vellechokre.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public abstract class BaseObject {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    // for soft delete support
    @Column(name = "is_active")
    private Boolean isActive = true;

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {

        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(final Date createdDate) {

        this.createdDate = createdDate;
    }

    /**
     * /**
     *
     * @return the updatedDate
     */
    public Date getUpdatedDate() {

        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(final Date updatedDate) {

        this.updatedDate = updatedDate;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {

        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(final Boolean isActive) {

        this.isActive = isActive;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {

        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(final String createdBy) {

        this.createdBy = createdBy;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {

        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(final String updatedBy) {

        this.updatedBy = updatedBy;
    }
}
