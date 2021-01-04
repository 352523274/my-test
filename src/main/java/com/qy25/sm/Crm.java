package com.qy25.sm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.qy25.sm")
public class Crm {
    public static void main(String[] args) {
        SpringApplication.run(Crm.class);
    }
}
