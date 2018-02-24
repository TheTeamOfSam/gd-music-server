package com.sam.graduation.design.gdmusicserver.controller.email.test;

import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.email.related.EmailResponseDto;
import com.sam.graduation.design.gdmusicserver.service.email.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/2/9 14:49:34
 */
@RestController
@Api("邮箱验证码相关接口")
@RequestMapping("/gdmusicserver")
public class EmailController extends BaseController {

    @Autowired
    private EmailService emailService;

    @ApiOperation("邮箱feign获取测试接口")
    @RequestMapping(value = "/email/@get", method = RequestMethod.POST)
    public EmailResponseDto getEmailCode(
            @RequestParam("email") String email
    ) {
        return this.emailService.sendEmailCode(email);
    }

    @ApiOperation("邮箱feign验证测试接口")
    @RequestMapping(value = "/email/@check", method = RequestMethod.POST)
    public EmailResponseDto checkEmailCode(
            @RequestParam("email") String email,
            @RequestParam("code") String code
    ) {
        return this.emailService.checkEmailCode(email, code);
    }

}
