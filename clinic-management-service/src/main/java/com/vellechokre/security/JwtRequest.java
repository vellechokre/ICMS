package com.vellechokre.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.vellechokre.entity.Branch;
import com.vellechokre.entity.Clinic;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;

    private String password;

    private Clinic clinic;

    private Set<Branch> branchs = new HashSet<>();

    // need default constructor for JSON Parsing
    public JwtRequest() {

    }

    public JwtRequest(String username, String password, Clinic clinic, Set<Branch> branchs) {

        setUsername(username);
        setPassword(password);
        setClinic(clinic);
        setBranchs(branchs);
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * @return the clinic
     */
    public Clinic getClinic() {

        return clinic;
    }

    /**
     * @param clinic the clinic to set
     */
    public void setClinic(Clinic clinic) {

        this.clinic = clinic;
    }

    /**
     * @return the branchs
     */
    public Set<Branch> getBranchs() {

        return branchs;
    }

    /**
     * @param branchs the branchs to set
     */
    public void setBranchs(Set<Branch> branchs) {

        this.branchs = branchs;
    }
}