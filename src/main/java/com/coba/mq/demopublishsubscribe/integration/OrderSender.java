package com.coba.mq.demopublishsubscribe.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/***
 * Created by IntelliJ IDEA
 * Project Name : demo-publish-subscribe
 * Username : Teten Nugraha
 * Date Time : 11/6/2019
 * Telegram : @tennugraha
 */

@Service
public class OrderSender {

    private static Logger log = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendTopic(Order order) {
        log.info("sending with convertAndSend() to topic <" + order + ">");
        jmsTemplate.convertAndSend("COBA_TOPIC", order);
    }
}
