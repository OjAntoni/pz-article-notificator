package com.example.pzarticlenotificator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@EnableFeignClients
public class PzArticleNotificatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PzArticleNotificatorApplication.class, args);
    }

}
