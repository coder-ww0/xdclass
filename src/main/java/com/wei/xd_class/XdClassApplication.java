package com.wei.xd_class;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.wei.xd_class.mapper")
@EnableTransactionManagement
public class XdClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdClassApplication.class, args);
    }

}
