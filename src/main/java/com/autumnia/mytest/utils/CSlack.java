package com.autumnia.mytest.utils;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ToString
public class CSlack {
    private String id;
    private String message;

    // 예시) CSlack.send("lm-bot", "https://hooks.slack.com/services/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", "에러 메시지");
    public void send(String username, String hookurl, String message) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

            Map<String, Object> request = new HashMap<String, Object>();
            request.put("username", username);
            request.put("text", message);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request, headers);

            restTemplate.exchange(hookurl, HttpMethod.POST, entity, String.class);
        } catch (Exception e) {
            log.info("message: {}", message);
            log.error(e.toString());
        }
    }

    public static void sender(String username, String hookurl, String message) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

            Map<String, Object> request = new HashMap<String, Object>();
            request.put("username", username);
            request.put("text", message);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request, headers);

            restTemplate.exchange(hookurl, HttpMethod.POST, entity, String.class);
        } catch (Exception e) {
            log.info("message: {}", message);
            log.error(e.toString());
        }
    }

    final public static class Builder {
        private String id;
        private String message;

        public Builder() {
        }

        public Builder setId(String v) {
            id = v;
            return this;
        }

        public Builder setMessage(String v) {
            message = v;
            return this;
        }

        public CSlack build() {
            return new CSlack(this);
        }
    }

	private CSlack(Builder builder) {
        id      = builder.id;
        message = builder.message;
    }

    public static void main(String[] args) {
        CSlack slack = new CSlack.Builder()
                .setId("PD_API_0002")
                .setMessage("dfksdfkldskflsd")
                .build();

//        CSlack.send("lottemart-monitoring-db",
//                "https://hooks.slack.com/services/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",
//                "DB 에러 메시지");

//        CSlack.send("lottemart-monitoring-server",
//                "https://hooks.slack.com/services/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",
//                "server 에러 메시지");

//        CSlack.send("lottemart-monitoring-jennifer",
//                "https://hooks.slack.com/services/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",
//                "jennifer 에러 메시지");

//        CSlack.send("lottemart-monitoring-batch",
//                "https://hooks.slack.com/services/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",
//                "batch 에러 메시지");

        slack.send("lottemart-monitoring-api",
                "https://hooks.slack.com/services/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",
                        slack.toString()
                );
    }
}
