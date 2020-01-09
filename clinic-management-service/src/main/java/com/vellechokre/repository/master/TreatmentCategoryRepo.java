package com.vellechokre.repository.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.master.TreatmentCategory;

/***
 * Project clinic-management-service**
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface TreatmentCategoryRepo extends JpaRepository<TreatmentCategory, Integer> {

    List<TreatmentCategory> findByTreatmentTypeId(Integer treatmentTypeId);
}
