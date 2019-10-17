package com.vellechokre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vellechokre.entity.Consultant;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface ConsultantRepo extends JpaRepository<Consultant, Integer> {

    @RequestMapping(value = "findByName")
    List<Consultant> findByName(@Param(value = "name") String name);
}
