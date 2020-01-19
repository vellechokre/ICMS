package com.vellechokre.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vellechokre.entity.Patient;
import com.vellechokre.entity.Visit;
import com.vellechokre.repository.projection.CategoryCountProjection;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface VisitRepo extends JpaRepository<Visit, Integer> {

    List<Visit> findByPatient(Patient patientDetail);

    long countByCreatedDateBetween(Date startDate, Date nextDate);

    @Query(nativeQuery = true,
           value = "SELECT " + "    v.category AS category, COUNT(v.category) AS count " + "FROM "
                   + "    visit v " + "GROUP BY " + "    v.category")
    List<CategoryCountProjection> findVisitCount();

    List<Visit> findByPatientId(Integer patientId);
}
