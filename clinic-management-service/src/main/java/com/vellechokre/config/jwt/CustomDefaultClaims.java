package com.vellechokre.config.jwt;

import java.util.Date;

import io.jsonwebtoken.impl.DefaultClaims;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Oct 20, 2019
 */
public class CustomDefaultClaims extends DefaultClaims implements CustomClaims {

    @Override
    public Date getLoginExpired() {

        return get(CustomClaims.LOGIN_EXPIRED, Date.class);
    }
}
