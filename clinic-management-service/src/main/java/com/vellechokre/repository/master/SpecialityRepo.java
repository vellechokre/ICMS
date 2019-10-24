package com.vellechokre.repository.master;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.master.Speciality;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 24, 2019
 */
public interface SpecialityRepo extends JpaRepository<Speciality, Integer> {}
