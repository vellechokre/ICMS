package com.vellechokre.admin.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.AdminService;
import com.vellechokre.entity.Branch;
import com.vellechokre.entity.Clinic;
import com.vellechokre.entity.DAOUser;
import com.vellechokre.repository.BranchRepo;
import com.vellechokre.repository.ClinicRepo;
import com.vellechokre.repository.UserDao;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 17, 2019
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ClinicRepo clinicRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Autowired
    private UserDao userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public Clinic createClinic(Clinic clinic) {

        clinic = new Clinic();
        clinic.setHasBranch(false);
        clinic.setName("Test Clinic");
        clinic.setCode("TSTCD");
        // create object for branch
        Branch branch = new Branch();
        branch.setName(clinic.getName());
        branch.setCode(clinic.getCode());
        createBranch(branch);
        // save clinic to DB
        return clinicRepo.save(clinic);
    }

    @Override
    public Branch createBranch(Branch branch) {

        branch = new Branch();
        branch.setName("Test Clinic");
        branch.setCode("TSTCD");
        branch.setBranchCode(branch.getCode());
        return branchRepo.save(branch);
    }

    @Override
    public DAOUser createUser(DAOUser user) {

        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<Clinic> getAllClinic() {

        return clinicRepo.findAll();
    }

    @Override
    public List<Branch> getBranchsByClinic(String clinicCode) {

        return branchRepo.findByClinicCode(clinicCode);
    }
}
