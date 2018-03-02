package com.sam.graduation.design.gdmusicserver.controller.user.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserDto;
import com.sam.graduation.design.gdmusicserver.dao.UserMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.User;
import com.sam.graduation.design.gdmusicserver.service.user.UserService;
import com.sam.graduation.design.gdmusicserver.utils.ConfusionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/2/28 17:08:14
 */
@RestController
@Api("用户相关接口")
@RequestMapping("/gdmusicserver")
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @ApiOperation("注册接口")
    @RequestMapping(value = "/user/service/@register", method = RequestMethod.POST)
    public Map<String, Object> userServiceRegister(
            @RequestParam("email") String rEmail,
            @RequestParam("nickname") String rNickname,
            @RequestParam("password") String rPassword,
            @RequestParam("sex") int rGender,
            @RequestParam("str_date_of_birth") String rDOfB,
            @RequestParam("province") String rProvince,
            @RequestParam("city") String rCity
    ) {

        if (StringUtils.isBlank(rEmail)) {
            return this.error("亲，邮箱不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(rNickname)) {
            return this.error("亲，昵称不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(rPassword)) {
            return this.error("亲，密码不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(rDOfB)) {
            return this.error("亲，请填写出生日期", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (!((rGender == 1) || (rGender == 2) || (rGender == 3))) {
            return this.error("亲，请正确选择性别", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(rProvince)) {
            return this.error("亲，请选择所在省", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(rCity)) {
            return this.error("亲，请选择所在市", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }

        UserDto dto = new UserDto();
        dto.setEmail(rEmail);
        dto.setNickname(rNickname);
        dto.setPassword(rPassword);
        dto.setSex((byte) rGender);
        // TODO: 强制转换日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        try {
            dateOfBirth = sdf.parse(rDOfB);
        } catch (ParseException e) {
            logger.error("e:{}", e);
        }
        if (dateOfBirth != null) {
            dto.setDateOfBirth(dateOfBirth);
        }
        dto.setProvince(rProvince);
        dto.setCity(rCity);

        UserDto userDto = null;
        try {
            userDto = this.userService.userRegister(dto);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userDto);
    }

    @ApiOperation("登录接口")
    @RequestMapping(value = "/user/service/@login", method = RequestMethod.POST)
    public Map<String, Object> userServiceLogin(
            @RequestParam("email") String lEmail,
            @RequestParam("password") String lPassword
    ) {
        if (StringUtils.isBlank(lEmail)) {
            return this.error("邮箱不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(lPassword)) {
            return this.error("密码不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        // TODO: 先验证账号是否存在
        User lUser = this.userMapper.selectByEmail(lEmail);
        if (lUser == null) {
            return this.error("该账号不存在", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }

        UserDto userDto = null;
        // TODO: 加盐后验证账号的密码是否正确
        String liPassword = ConfusionUtil.pwToMD5(lPassword, lUser.getId());
        UserDto dto = new UserDto();
        dto.setEmail(lEmail);
        dto.setPassword(liPassword);
        try {
            userDto = this.userService.userLogin(dto);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userDto == null) {
            return this.error("系统异常，用户名或密码不存在！", ServiceResultType.RESULT_MD5_SYSTEM_ERROR);
        }
        return this.success(userDto);
    }

}
