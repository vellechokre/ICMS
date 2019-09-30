package com.vellechokre.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class SmsUtil {

    public static Map<String, Object> buildParams(String number, String message) {

        final Map<String, Object> params = new HashMap<>();
        params.put(ApplicationConstant.AUTH_KEY, ApplicationConstant.AUTH_KEY_VALUE);
        params.put(ApplicationConstant.MOBILE, "91" + number);
        params.put(ApplicationConstant.SENDER_ID, ApplicationConstant.SENDER_ID_VALUE);
        params.put(ApplicationConstant.ROUTE, ApplicationConstant.ROUTE_VALUE);
        params.put(ApplicationConstant.MESSAGE, message);
        return params;
    }

    public static String buildSmsBody(String name, String message) {

        final StringBuilder sb = new StringBuilder();
        sb.append("Hello ").append(name).append(",").append("\n").append("\n");
        sb.append(message);
        return sb.toString();
    }
}
