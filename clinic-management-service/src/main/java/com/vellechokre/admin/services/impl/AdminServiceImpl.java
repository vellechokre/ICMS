package com.vellechokre.admin.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vellechokre.admin.services.AdminService;
import com.vellechokre.bo.BranchBo;
import com.vellechokre.entity.Branch;
import com.vellechokre.entity.Clinic;
import com.vellechokre.entity.LoginUser;
import com.vellechokre.entity.master.Speciality;
import com.vellechokre.repository.BranchRepo;
import com.vellechokre.repository.ClinicRepo;
import com.vellechokre.repository.LoginUserRepo;
import com.vellechokre.repository.master.SpecialityRepo;

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
    private LoginUserRepo userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private SpecialityRepo specialityRepo;

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
        // createBranch(branch);
        // save clinic to DB
        clinicRepo.save(clinic);
        branch.setClinic(clinic);
        Set<Speciality> specialities = new HashSet<>();
        specialityRepo.findAll().forEach(item -> {
            specialities.add(item);
        });
        branch.setSpecialities(specialities);
        branchRepo.save(branch);
        return clinic;
    }

    @Override
    public Branch createBranch(Branch branch) {

        branch = new Branch();
        branch.setName("Test Clinic");
        branch.setCode(branch.getCode());
        return branchRepo.save(branch);
    }

    @Override
    public LoginUser createUser(LoginUser user) {

        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<Clinic> getAllClinic() {

        return clinicRepo.findAll();
    }

    @Override
    public List<BranchBo> getBranchsByClinic(String clinicCode) {

        // Clinic clinic = clinicRepo.findByCode(clinicCode);
        List<Branch> dbBanches = branchRepo.findByClinicCode(clinicCode);
        return dbBranchToBranchBo(dbBanches);
    }

    public List<BranchBo> dbBranchToBranchBo(List<Branch> dbBanches) {

        List<BranchBo> branches = new ArrayList<>();
        dbBanches.forEach(item -> {
            BranchBo branch = new BranchBo();
            BeanUtils.copyProperties(item, branch);
            branches.add(branch);
        });
        return branches;
    }
}
