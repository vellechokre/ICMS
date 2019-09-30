package com.vellechokre.util;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class RestUtil {

    public static void get(String url, Map<String, Object> params) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        // Add query parameter
        params.forEach((key, value) -> {
            builder.queryParam(key, value);
        });
        System.out.println("*****************************************************");
        System.out.println(builder.toUriString());
        RestTemplate restTemplate = new RestTemplate();
        // restTemplate.getForObject(builder.toUriString(), Object.class);
        ResponseEntity<String> response =
                restTemplate.getForEntity(builder.toUriString(), String.class);
        System.out.println(response);
        System.out.println(response.getBody());
        System.out.println("*****************************************************");
    }
}
