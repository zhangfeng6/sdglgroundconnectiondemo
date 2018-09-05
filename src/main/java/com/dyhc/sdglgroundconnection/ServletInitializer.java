package com.dyhc.sdglgroundconnection;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SdglgroundconnectionApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SdglgroundconnectionApplication.class, args);
    }
}
