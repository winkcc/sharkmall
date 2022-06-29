package com.wink;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wink.mapper")
public class TwmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwmallApplication.class, args);
        //启动打开主页
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:8080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
