package com.coba.mq.demopublishsubscribe.integration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/***
 * Created by IntelliJ IDEA
 * Project Name : demo-publish-subscribe
 * Username : Teten Nugraha
 * Date Time : 11/6/2019
 * Telegram : @tennugraha
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order implements Serializable {

    private String from;
    private String to;
    private BigDecimal amount;
    private LocalDateTime timestampt;

}
