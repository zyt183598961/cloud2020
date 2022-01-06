package com.zyt.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient //注册发现服务
@EnableHystrixDashboard //开启仪表盘
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
        System.out.println("仪表盘启动");
    }

}
