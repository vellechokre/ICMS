package com.vellechokre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vellechokre.entity.UserLogin;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer> {

    UserLogin findByUserNameAndPassword(String username, String password);
}
