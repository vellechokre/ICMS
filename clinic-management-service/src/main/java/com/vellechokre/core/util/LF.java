package com.vellechokre.core.util;

import org.springframework.util.StringUtils;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
public class LF {

    /**
     * Format.
     *
     * @param message the message
     * @return the string
     */
    public static String format(final String message) {

        return format(message, null);
    }

    /**
     * Format.
     *
     * @param message the message
     * @param tenantId the tenant id
     * @param service the service
     * @return formatted string
     */
    public static String format(final String message, String tenantId) {

        if (StringUtils.isEmpty(tenantId)) {
            tenantId = "-1";
        }
        return String.format("[TENANT_ID:%s ]    %s", tenantId, message);
    }
}
