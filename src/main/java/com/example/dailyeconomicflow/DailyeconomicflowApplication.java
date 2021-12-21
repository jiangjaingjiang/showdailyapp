package com.example.dailyeconomicflow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.dailyeconomicflow.dao")
public class DailyeconomicflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyeconomicflowApplication.class, args);
    }

}
