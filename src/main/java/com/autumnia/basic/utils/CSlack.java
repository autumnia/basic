package com.autumnia.basic.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class CSlack {
    public static void send(String username, String hookurl, String message) {
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

            Map<String,Object> request = new HashMap<String,Object>();
            request.put("username", username);
            request.put("text", message);

            HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request, headers);

            restTemplate.exchange(hookurl, HttpMethod.POST, entity, String.class);
        } catch (Exception e) {
            log.info("message: {}", message);
            log.error(e.toString());
        }
    }
}
