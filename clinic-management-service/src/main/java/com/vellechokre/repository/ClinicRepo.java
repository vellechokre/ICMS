package com.vellechokre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.Clinic;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
public interface ClinicRepo extends JpaRepository<Clinic, Integer> {}
