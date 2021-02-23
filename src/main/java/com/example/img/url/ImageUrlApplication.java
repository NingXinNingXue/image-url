package com.example.img.url;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author NingXue
 */
@SpringBootApplication
@MapperScan("com.example.img.url.mapper")
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ImageUrlApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImageUrlApplication.class, args);
    }
}
