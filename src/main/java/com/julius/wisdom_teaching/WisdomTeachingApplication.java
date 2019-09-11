package com.julius.wisdom_teaching;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.julius.wisdom_teaching.repository"})
public class WisdomTeachingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WisdomTeachingApplication.class, args);
    }

}
