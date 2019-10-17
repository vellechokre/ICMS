package com.vellechokre.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.master.City;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
public interface CityRepo extends JpaRepository<City, Integer> {}
