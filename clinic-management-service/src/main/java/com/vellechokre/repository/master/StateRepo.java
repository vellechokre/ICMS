package com.vellechokre.repository.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.master.State;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
public interface StateRepo extends JpaRepository<State, Integer> {

    List<State> findByCountryId(Integer countryId);
}
