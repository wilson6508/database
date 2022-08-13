package com;

import com.service.test.TestService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner run(TestService testService) {
//        return (args -> {
//            System.out.println("666");
//            testService.demo3();
//            System.out.println("777");
//        });
//    }

}
