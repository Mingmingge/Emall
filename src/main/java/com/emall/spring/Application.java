package com.emall.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.emall.spring.dao")
@ServletComponentScan  //springboot启动类扫描servlet组件(过滤器)
public class Application {

    /**
     * 测试
     *
     * @return 测试用
     */

    @RequestMapping("/")
    public String index() {
        return "ok!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}