package com.vellechokre.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.master.Country;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
public interface CountryRepo extends JpaRepository<Country, Integer> {}
