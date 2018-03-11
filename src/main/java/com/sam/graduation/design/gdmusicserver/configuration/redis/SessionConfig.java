package com.sam.graduation.design.gdmusicserver.configuration.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 13:53:29
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
}
