package com.zyt.consumer.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HystrixConfig {

    /**
     * 服务配置的实时数据采集  默认servlet
     * @return  ServletRegistrationBean对象
     */
    @Bean
    public ServletRegistrationBean create() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("hystrix.stream");
        return registrationBean;
    }

}
