package com.vellechokre.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vellechokre.entity.LoginUser;

@Repository
public interface LoginUserRepo extends CrudRepository<LoginUser, Integer> {

    LoginUser findByUsername(String username);

    LoginUser findByUsernameAndClinicIdAndBranchsIdIn(String username, Integer clinicId,
                                                      List<Integer> branchIds);
}