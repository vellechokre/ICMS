package com.vellechokre.util;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public static Object post(final String url, final Map<String, String> requestHeaders,
                              final Object objectToPost) {

        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        // headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        for (final Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            headers.add(entry.getKey(), entry.getValue());
        }
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode rootNode = mapper.valueToTree(objectToPost);
        final HttpEntity<Object> entity = new HttpEntity<Object>(rootNode, headers);
        final ResponseEntity<Object> responseEntity =
                restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
        return responseEntity.getBody();
    }

    public static Object get(String url, final Map<String, String> requestHeaders,
                             final Map<String, String> params) {

        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        for (final Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            headers.add(entry.getKey(), entry.getValue());
        }
        final MultiValueMap<String, String> mv = new LinkedMultiValueMap<String, String>();
        for (final Map.Entry<String, String> entry : params.entrySet()) {
            mv.add(entry.getKey(), entry.getValue());
        }
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        final UriComponents urlNew = UriComponentsBuilder.fromHttpUrl(url).queryParams(mv).build();
        url = urlNew.toString();
        final ResponseEntity<Object> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, entity, Object.class, params);
        return responseEntity.getBody();
    }
}
