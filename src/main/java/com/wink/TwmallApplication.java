package com.wink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wink.mapper")
public class TwmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwmallApplication.class, args);
    }

}
