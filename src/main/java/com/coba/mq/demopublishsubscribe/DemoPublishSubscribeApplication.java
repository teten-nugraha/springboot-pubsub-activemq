package com.coba.mq.demopublishsubscribe;

import com.coba.mq.demopublishsubscribe.integration.Order;
import com.coba.mq.demopublishsubscribe.integration.OrderSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoPublishSubscribeApplication  implements ApplicationRunner {

    private static Logger log = LoggerFactory.getLogger(DemoPublishSubscribeApplication.class);

    @Autowired
    private OrderSender orderSender;

    public static void main(String[] args) {
        SpringApplication.run(DemoPublishSubscribeApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Spring Boot ActiveMQ Publish Subscribe Topic Configuration Example");

        for (int i = 0; i < 5; i++){
            Order order = new Order("me", "you", new BigDecimal(i), LocalDateTime.now());
            orderSender.sendTopic(order);
        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        TimeUnit.SECONDS.sleep(3);
        System.exit(-1);
    }
}
