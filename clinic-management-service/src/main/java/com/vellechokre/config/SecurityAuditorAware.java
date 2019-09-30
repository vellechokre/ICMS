package com.vellechokre.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Aug 28, 2019
 */
@Component
public class SecurityAuditorAware implements AuditorAware<String> {

    /**
     * This method is used to tell the the JPA about the logged in user.
     *
     * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
     */
    private String roles;

    private String permissions;

    @Override
    public Optional<String> getCurrentAuditor() {

        return Optional.of("SYSTEM");
    }

    /**
     * Get emailId of logged in user.
     *
     * @return String
     */
    public String getEmailId() {

        Optional<String> result = getCurrentAuditor();
        return result.isPresent() ? result.get() : "SYSTEM";
    }

    public String getRoles() {

        return roles;
    }

    public void setRoles(final String roles) {

        this.roles = roles;
    }

    public String getPermissions() {

        getCurrentAuditor();
        return permissions;
    }

    public void setPermissions(final String permissions) {

        this.permissions = permissions;
    }
}
