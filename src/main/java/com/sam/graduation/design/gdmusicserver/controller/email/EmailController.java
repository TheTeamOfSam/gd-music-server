package com.sam.graduation.design.gdmusicserver.controller.email;

import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.email.related.EmailResponseDto;
import com.sam.graduation.design.gdmusicserver.dao.UserMapper;
import com.sam.graduation.design.gdmusicserver.service.email.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮箱验证码相关接口
 *
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/2/9 14:49:34
 */
@RestController
@Api("邮箱验证码相关接口")
@RequestMapping("/gdmusicserver")
public class EmailController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailService emailService;

    /**
     * 注册的邮箱feign获取测试接口
     *
     * @param email 邮箱
     * @return EmailResponseDto
     */
    @ApiOperation("注册的邮箱feign获取测试接口")
    @RequestMapping(value = "/email/@get", method = RequestMethod.POST)
    public EmailResponseDto getEmailCode(
            @RequestParam("email") String email
    ) {
        if (StringUtils.isBlank(email)) {
            EmailResponseDto dto = new EmailResponseDto();
            dto.setSuccess(false);
            dto.setFeedbackMessage("亲，请输入邮箱！");
            return dto;
        }
        if (this.userMapper.selectByEmail(email) != null) {
            EmailResponseDto dto = new EmailResponseDto();
            dto.setSuccess(false);
            dto.setFeedbackMessage("亲，该邮箱已经被注册！");
            return dto;
        }
        return this.emailService.sendEmailCode(email);
    }

    /**
     * 重置密码的邮箱发送接口
     *
     * @param email 邮箱
     * @return EmailResponseDto
     */
    @ApiOperation("重置密码的邮箱发送接口")
    @RequestMapping(value = "/reset/password/email/@get", method = RequestMethod.POST)
    public EmailResponseDto getResetPasswordEmailCode(
            @RequestParam(value = "email", required = false) String email
    ) {
        if (StringUtils.isBlank(email)) {
            EmailResponseDto dto = new EmailResponseDto();
            dto.setSuccess(false);
            dto.setFeedbackMessage("亲，请输入邮箱账号！");
            return dto;
        }
        if (this.userMapper.selectByEmail(email) == null) {
            EmailResponseDto dto = new EmailResponseDto();
            dto.setSuccess(false);
            dto.setFeedbackMessage("亲，账号不存在！");
            return dto;
        }
        return this.emailService.sendResetPasswordEmailCode(email);
    }

    /**
     * 注册的邮箱feign验证测试接口
     *
     * @param email 邮箱号
     * @param code  邮箱验证码
     * @return EmailResponseDto
     */
    @ApiOperation("注册的邮箱feign验证测试接口")
    @RequestMapping(value = "/email/@check", method = RequestMethod.POST)
    public EmailResponseDto checkEmailCode(
            @RequestParam("email") String email,
            @RequestParam("code") String code
    ) {
        if (StringUtils.isBlank(email)) {
            EmailResponseDto dto = new EmailResponseDto();
            dto.setFeedbackMessage("亲，请输入邮箱！");
            dto.setSuccess(false);
            return dto;
        }
        if (StringUtils.isBlank(code)) {
            EmailResponseDto dto = new EmailResponseDto();
            dto.setSuccess(false);
            dto.setFeedbackMessage("亲，请输入验证码！");
            return dto;
        }
        return this.emailService.checkEmailCode(email, code);
    }

}
