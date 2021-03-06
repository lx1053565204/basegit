package com.luxu.basegit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@MapperScan("com.luxu.basegit.mapper")//使用MapperScan批量扫描所有的Mapper接口；
@SpringBootApplication
public class BasegitApplication {

    public static void main(String[] args) {

        SpringApplication.run(BasegitApplication.class, args);
    }

}
