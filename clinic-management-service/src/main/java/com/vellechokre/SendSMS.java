package com.vellechokre;

import java.util.HashMap;
import java.util.Map;

import com.vellechokre.util.ApplicationConstant;
import com.vellechokre.util.RestUtil;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 15, 2020
 */
public class SendSMS {

    public static void main(String[] args) {

        final Map<String, Object> params = buildParams("7008488820", "test");
        RestUtil.get(ApplicationConstant.BASE_URL_SMS, params);
    }

    public static Map<String, Object> buildParams(String number, String message) {

        final Map<String, Object> params = new HashMap<>();
        params.put(ApplicationConstant.AUTH_KEY, ApplicationConstant.AUTH_KEY_VALUE);
        params.put(ApplicationConstant.MOBILE, "91" + number);
        params.put(ApplicationConstant.SENDER_ID, "KITTU");
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
