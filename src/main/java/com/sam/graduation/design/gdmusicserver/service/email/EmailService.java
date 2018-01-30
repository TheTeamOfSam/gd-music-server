package com.sam.graduation.design.gdmusicserver.service.email;

import com.sam.graduation.design.gdmusicserver.controller.dto.email.related.EmailResponseDto;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/1/30 12:02:52
 */
public interface EmailService {

    EmailResponseDto sendEmailCode(@RequestParam("email") String email);

    EmailResponseDto checkEmailCode(@RequestParam("email") String email, @RequestParam("code") String code);

}
