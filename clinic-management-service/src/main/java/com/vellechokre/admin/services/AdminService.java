package com.vellechokre.admin.services;

import java.util.List;

import com.vellechokre.bo.BranchBo;
import com.vellechokre.entity.Branch;
import com.vellechokre.entity.Clinic;
import com.vellechokre.entity.LoginUser;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 17, 2019
 */
public interface AdminService {

    /**
     * @param clinic
     * @return
     */
    Clinic createClinic(Clinic clinic);

    /**
     * @param branch
     * @return
     */
    Branch createBranch(Branch branch);

    /**
     * @param user
     * @return
     */
    LoginUser createUser(LoginUser user);

    /**
     * @return
     */
    List<Clinic> getAllClinic();

    /**
     * @param clinicCode
     * @return
     */
    List<BranchBo> getBranchsByClinic(String clinicCode);
}
