package com.zsl.easyexcelpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "com.zsl.easyexcelpro.mapper")
public class EasyexcelProApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyexcelProApplication.class, args);
    }

}
