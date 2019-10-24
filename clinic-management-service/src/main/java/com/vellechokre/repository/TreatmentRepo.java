package com.vellechokre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.Treatment;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 20, 2019
 */
public interface TreatmentRepo extends JpaRepository<Treatment, Integer> {}
