package com.vellechokre.entity.base;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
public abstract class BaseObjectWithId extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * @return the id
     */
    public Integer getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {

        this.id = id;
    }
}
