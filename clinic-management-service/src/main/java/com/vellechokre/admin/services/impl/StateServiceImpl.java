package com.vellechokre.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.StateService;
import com.vellechokre.entity.master.State;
import com.vellechokre.repository.master.StateRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Nov 30, 2019
 */
@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepo repo;

    @Override
    public State save(State state) {

        return repo.save(state);
    }

    @Override
    public List<State> fetchAll() {

        return repo.findAll();
    }

    @Override
    public List<State> getStateByCountry(Integer id) {

        return repo.findByCountryId(id);
    }
}
