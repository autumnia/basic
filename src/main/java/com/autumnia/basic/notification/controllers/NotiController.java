package com.autumnia.basic.notification.controllers;

import com.autumnia.basic.notification.services.IAlertService;
import com.autumnia.basic.utils.CSlack;
import com.autumnia.basic.utils.CTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequestMapping("/slack")
@RestController
public class NotiController {
    private final Environment env;
    private final IAlertService alertService;

    @Autowired
    public NotiController(Environment env, IAlertService alertService) {
        this.env = env;
        this.alertService = alertService;
    }

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        CSlack.send("lm-bot", env.getProperty("slack.api.hookurl"), message);

        return "slack send";
    }

//    @GetMapping("/send/{message}")
//    public String sendMessage(@PathVariable String message) {
//        try{
//            this.alertService.sendMessage(message);
//            log.info("message: {}", message);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//
//        return "홈페이지";
//    }

//    @GetMapping("/send/{message}") 실패버전
//    public String sendMessage(@PathVariable String messege) {
//        try {
//           WebhookResponse response = null;
//           Slack slack = Slack.getInstance();
//
//           String webhookUrl = env.getProperty("slack.api.hookurl");
//           Payload payload = Payload.builder()
//                    .text(messege)
//                    .build();
//
//           response = slack.send(webhookUrl, payload);
//           return "발송";
//        } catch (Exception e) {
//            log.error(e.toString());
//            throw new RuntimeException(e);
//        }
//    }

    @GetMapping("/status")
    public String status(HttpServletRequest request) {
        log.info("서비스 정상작동 중 입니다. ");
        log.info("현재시간: {}", CTime.getCurrentTime("yyyy-MM-dd HH:mm:ss") );
        log.info("서버포트: {}", this.env.getProperty("server.port") );

        String msg = String.format("서비스 정상작동 중 입니다");
        return msg ;
    }

}
