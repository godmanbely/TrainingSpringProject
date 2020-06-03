package com.miluo.bookman;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.miluo.bookman.mapper")
public class BookmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanApplication.class, args);
    }

}
