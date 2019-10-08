package com.hui;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@SpringBootApplication(scanBasePackages={"com.hui.*"})
@MapperScan(basePackages={"com.hui.mapper.*"})
public class ApplicationUser {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationUser.class);
    }
}
