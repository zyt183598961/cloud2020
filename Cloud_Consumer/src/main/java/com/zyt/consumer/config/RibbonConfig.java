package com.zyt.consumer.config;


import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.TreeMap;


@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced //启用负载均衡
    public RestTemplate createRT(){
        return new RestTemplate();
    }

    //创建负载策略
    @Bean
    public IRule createStrategy(){

        //随机
        RandomRule randomRule = new RandomRule();

        //默认轮询
        RoundRobinRule roundRobinRule = new RoundRobinRule();

        //区域感知
        ZoneAvoidanceRule zoneAvoidanceRule = new ZoneAvoidanceRule();

        //最低迸发 逐个考察server，如果server断路器打开，则忽略，再选择其中并发链接最低的server
        BestAvailableRule availableRule = new BestAvailableRule();

        //可用过滤策略	过滤掉一直失败并被标记为circuit tripped的server，过滤掉那些高并发链接的server（active connections超过配置的阈值）或者使用一个AvailabilityPredicate来包含过滤server的逻辑
        // 其实就就是检查status里记录的各个Server的运行状态；
        WeightedResponseTimeRule weightedResponseTimeRule = new WeightedResponseTimeRule();

        //根据响应时间判断权重，时长越高，权重越低;
        ResponseTimeWeightedRule timeWeightedRule = new ResponseTimeWeightedRule();
        return roundRobinRule;
    }

}
