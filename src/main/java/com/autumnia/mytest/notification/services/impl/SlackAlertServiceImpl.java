package com.autumnia.mytest.notification.services.impl;

import com.autumnia.mytest.notification.services.IAlertService;
import com.slack.api.Slack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SlackAlertServiceImpl implements IAlertService {
    private final Environment env;

    @Autowired
    public SlackAlertServiceImpl(Environment env) {
        this.env = env;
    }


    @Override
    public void sendMessage(String message) throws Exception {
        String token = env.getProperty("slack.token");
        String channel = env.getProperty("slack.channel.monitor");

        log.info("token: {}, channel: {}", token, channel);

        Slack slack = Slack.getInstance();
        slack.methods(token).chatPostMessage(req -> req.channel(channel).text(message));
    }


}
