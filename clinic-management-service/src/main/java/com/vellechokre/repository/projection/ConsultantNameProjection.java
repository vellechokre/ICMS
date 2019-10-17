package com.vellechokre.repository.projection;

import org.springframework.data.rest.core.config.Projection;

import com.vellechokre.entity.Consultant;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Projection(name = "consultantNameProjection", types = {Consultant.class})
public interface ConsultantNameProjection {

    String getName();
}
