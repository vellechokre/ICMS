package com.vellechokre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vellechokre.entity.base.BaseObject;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Entity(name = EntityContant.EMAIL_DETAIL_T)
public class EmailDetails extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String host;

    private String port;

    private String username;

    private String password;

    /**
     * @return the id
     */
    public Integer getId() {

        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {

        this.id = id;
    }

    /**
     * @return the host
     */
    public String getHost() {

        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(final String host) {

        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort() {

        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(final String port) {

        this.port = port;
    }

    /**
     * @return the username
     */
    public String getUsername() {

        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(final String username) {

        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {

        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {

        this.password = password;
    }
}
