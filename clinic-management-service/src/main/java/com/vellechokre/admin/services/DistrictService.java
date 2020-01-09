package com.vellechokre.admin.services;

import java.util.List;

import com.vellechokre.entity.master.District;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
public interface DistrictService {

    /**
     * @param district
     * @return
     */
    District save(District district);

    /**
     * @return
     */
    List<District> fetchAll();

    /**
     * @param stateId
     * @return
     */
    List<District> getDistrictByStateId(Integer stateId);
}
