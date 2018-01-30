package com.sam.graduation.design.gdmusicserver.feign.client;

import com.sam.graduation.design.gdmusicserver.controller.dto.email.related.EmailResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/1/30 11:51:39
 */
@FeignClient(name = "gd-email-server", url = "")
public interface EmailClient {

    // 发送邮箱验证码
    @RequestMapping(value = "/gdemailserver/email/code/@send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    EmailResponseDto sendEmailCode(@RequestParam("email") String email);

    // 验证短信验证码
    @RequestMapping(value = "/gdemailserver/email/code/@check", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    EmailResponseDto checkEmailCode(@RequestParam("email") String email, @RequestParam("code") String code);

}
