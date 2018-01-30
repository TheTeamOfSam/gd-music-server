package com.sam.graduation.design.gdmusicserver.service.email.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.email.related.EmailResponseDto;
import com.sam.graduation.design.gdmusicserver.feign.client.EmailClient;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/1/30 12:03:16
 */
@Service
public class EmailServiceImpl extends BaseService implements EmailService {

    @Autowired
    private EmailClient emailClient;

    @Override
    public EmailResponseDto sendEmailCode(String email) {
        EmailResponseDto dto = this.emailClient.sendEmailCode(email);
        return dto;
    }

    @Override
    public EmailResponseDto checkEmailCode(String email, String code) {
        EmailResponseDto dto = this.emailClient.checkEmailCode(email, code);
        return dto;
    }
}
