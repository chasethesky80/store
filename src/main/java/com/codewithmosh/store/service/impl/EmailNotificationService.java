package com.codewithmosh.store.service.impl;

import com.codewithmosh.store.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @Value("${host}")
    private String host;

    @Value("${port}")
    private Integer port;
    @Override
    public void send(String message, String recipientEmail) {
        System.out.println(String.format("SENDING EMAIL MESSAGE %s TO HOST AND PORT %s %s",
                message, host, port));
    }
}
