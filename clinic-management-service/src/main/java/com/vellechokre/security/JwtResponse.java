package com.vellechokre.security;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vellechokre.bo.LoginUserBo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    private LoginUserBo user;

    public JwtResponse(String jwttoken, LoginUserBo user) {

        this.jwttoken = jwttoken;
        this.user = user;
    }

    public String getToken() {

        return jwttoken;
    }

    /**
     * @return the user
     */
    public LoginUserBo getUser() {

        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(LoginUserBo user) {

        this.user = user;
    }

    /**
     * @return the jwttoken
     */
    public String getJwttoken() {

        return jwttoken;
    }
}