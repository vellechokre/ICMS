package com.vellechokre.entity.master;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.vellechokre.entity.base.BaseObject;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
@MappedSuperclass
public class AbstractLocation extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String geonameId;

    private String name;

    private String code;

    private BigDecimal population;

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

    /**
     * @return the geonameId
     */
    public String getGeonameId() {

        return geonameId;
    }

    /**
     * @param geonameId the geonameId to set
     */
    public void setGeonameId(String geonameId) {

        this.geonameId = geonameId;
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
     * @return the population
     */
    public BigDecimal getPopulation() {

        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(BigDecimal population) {

        this.population = population;
    }
}
