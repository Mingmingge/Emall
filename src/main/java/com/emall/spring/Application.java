package com.emall.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.converter.json.SpringHandlerInstantiator;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.emall.spring.dao")
//@ServletComponentScan  //springboot启动类扫描servlet组件(过滤器)
public class Application {


    /**
     * 测试
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

//@SpringBootApplication
//@MapperScan("com.emall.spring.dao")
//public class Application extends SpringBootServletInitializer{
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Application.class);
//    }
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//
//}