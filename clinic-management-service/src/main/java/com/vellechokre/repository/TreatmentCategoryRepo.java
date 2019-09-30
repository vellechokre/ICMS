package com.vellechokre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.TreatmentCategory;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface TreatmentCategoryRepo extends JpaRepository<TreatmentCategory, Integer> {
    // List<String> findDiscription();
}
