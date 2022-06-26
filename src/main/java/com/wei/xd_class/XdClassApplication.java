package com.wei.xd_class;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wei.xd_class.mapper")
public class XdClassApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdClassApplication.class, args);
    }

}
