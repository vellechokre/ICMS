package com.vellechokre.repository.projection;

import org.springframework.data.rest.core.config.Projection;

import com.vellechokre.entity.Visit;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Projection(name = "categoryCountProjection", types = {Visit.class})
public interface CategoryCountProjection {

    String getCategory();

    long getCount();
}
