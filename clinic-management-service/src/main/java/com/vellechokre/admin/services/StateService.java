package com.vellechokre.admin.services;

import java.util.List;

import com.vellechokre.entity.master.State;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
public interface StateService {

    /**
     * @param state
     * @return
     */
    State save(State state);

    /**
     * @return
     */
    List<State> fetchAll();

    /**
     * @param id
     * @return
     */
    List<State> getStateByCountry(Integer id);
}
