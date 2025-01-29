package com.thortful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ThortfulApplication {

  public static void main(String[] args) {
    SpringApplication.run(ThortfulApplication.class, args);
  }

}
