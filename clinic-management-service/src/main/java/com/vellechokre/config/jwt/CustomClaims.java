package com.vellechokre.config.jwt;

import java.util.Date;

import io.jsonwebtoken.Claims;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 20, 2019
 */
public interface CustomClaims extends Claims {

    public static final String LOGIN_EXPIRED = "loginExpired";

    public Date getLoginExpired();
}
