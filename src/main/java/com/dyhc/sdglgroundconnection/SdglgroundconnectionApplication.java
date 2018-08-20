package com.dyhc.sdglgroundconnection;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
/*@MapperScan(basePackages = {"com.dyhc.sdglgroundconnection.mapper"}) // 用于扫描的mapper接口*/
public class SdglgroundconnectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SdglgroundconnectionApplication.class, args);
    }
}
