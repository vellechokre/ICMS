package com.vellechokre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vellechokre.entity.ConsultantDetail;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface ConsultantDetailsRepo extends JpaRepository<ConsultantDetail, Integer> {

    @RequestMapping(value = "findByName")
    List<ConsultantDetail> findByName(@Param(value = "name") String name);
}
