package com.vellechokre.entity.master;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import com.vellechokre.entity.EntityContant;

/**
 * Project authorization_server
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Aug 27, 2019
 */
@Entity(name = EntityContant.LOGIN_AUTHORITY)
public class LoginAuthority implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authority;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Override
    public String getAuthority() {

        return authority;
    }

    public void setAuthority(String authority) {

        this.authority = authority;
    }
}
