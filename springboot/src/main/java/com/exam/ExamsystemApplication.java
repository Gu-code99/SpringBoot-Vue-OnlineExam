package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class ExamsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamsystemApplication.class, args);
        System.out.println("后台已启动！！！");
    }
}

