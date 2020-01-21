package com.ricky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ricky.mapper")
public class MybatisCascadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisCascadeApplication.class, args);
    }
}
