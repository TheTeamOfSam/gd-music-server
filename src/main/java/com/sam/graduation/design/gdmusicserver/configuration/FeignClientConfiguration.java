package com.sam.graduation.design.gdmusicserver.configuration;

import feign.Request;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignClient 配置
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/1/30 12:21:41
 */
@Configuration
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sam.graduation.design.gdmusicserver.feign.client")
public class FeignClientConfiguration {

    public static int connectTimeOutMillis = 12000;
    public static int readTimeOutMillis = 12000;

    @Bean
    public Request.Options options(){
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

}
