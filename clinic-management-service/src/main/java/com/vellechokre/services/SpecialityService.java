package com.vellechokre.services;

import com.vellechokre.entity.master.Speciality;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 24, 2019
 */
public interface SpecialityService {

    /**
     * @param speciality
     * @return
     */
    Speciality create(Speciality speciality);
}
