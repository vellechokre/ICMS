package com.vellechokre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.Branch;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 16, 2019
 */
public interface BranchRepo extends JpaRepository<Branch, Integer> {

    List<Branch> findByClinicCode(String clinicCode);

    List<Branch> findByClinicId(Integer id);
}
