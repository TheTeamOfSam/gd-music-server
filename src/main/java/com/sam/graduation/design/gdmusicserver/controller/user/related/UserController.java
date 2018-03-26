package com.sam.graduation.design.gdmusicserver.controller.user.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserAndCreatedMLAndCollectedMLDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserDto;
import com.sam.graduation.design.gdmusicserver.dao.UserMapper;
import com.sam.graduation.design.gdmusicserver.model.enums.related.UserSex;
import com.sam.graduation.design.gdmusicserver.model.pojo.User;
import com.sam.graduation.design.gdmusicserver.service.user.UserService;
import com.sam.graduation.design.gdmusicserver.utils.ConfusionUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    /**
     * 更改头像接口
     *
     * @param headPhoto 传入的图片文件
     * @param userID    用户id
     * @return
     */
    @ApiOperation("更改头像接口")
    @RequestMapping(value = "/user/service/head/photo/@change", method = RequestMethod.POST)
    public Map<String, Object> userServiceHeadPhotoChange(
            @RequestParam("head_photo") MultipartFile headPhoto,
            @RequestParam("userId") Long userID
    ) {
        if (headPhoto == null || headPhoto.getSize() == 0) {
            return this.error("亲，请上传头像图片文件！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        String hpOraName = headPhoto.getOriginalFilename();
        String hpFormat = hpOraName.toLowerCase().substring(hpOraName.lastIndexOf("."), hpOraName.length());
        if (!(hpFormat.equals(".jpg") || hpFormat.equals(".jpeg") ||
                hpFormat.equals(".bmp") || hpFormat.equals(".png"))) {
            return this.error("亲，请上传jpg/jpeg/bmp/png格式的图片！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }

        MessageDto messageDto = null;
        try {
            messageDto = this.userService.userHeadPhotoUpdate(userID, headPhoto);
        } catch (Exception e) {
            logger.error("e:{}!", e);
        }
        if (messageDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(messageDto);
    }

    /**
     * 注册接口
     *
     * @param rEmail    邮箱
     * @param rNickname 昵称
     * @param rPassword 密码
     * @param rGender   性别
     * @param rDOfB     出生日期
     * @param rProvince 省份
     * @param rCity     城市
     * @return
     */
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
        if (!((rGender == UserSex.MALE.value()) || (rGender == UserSex.FEMALE.value()) ||
                (rGender == UserSex.SECRET.value()))) {
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

    /**
     * 登录接口
     *
     * @param lEmail    邮箱
     * @param lPassword 密码
     * @return
     */
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

    /**
     * 获取个人信息
     *
     * @param userID 用户id
     * @return
     */
    @ApiOperation("获取个人信息接口")
    @RequestMapping(value = "/user/service/info/@get", method = RequestMethod.POST)
    public Map<String, Object> userServiceInfoGet(
            @RequestParam("uID") Long userID
    ) {
        if (userID < 0) {
            return this.error("ID错误", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        UserDto userDto = null;
        try {
            userDto = this.userService.userInfoGet(userID);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userDto == null) {
            return this.error("未获得用户信息！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        return this.success(userDto);
    }

    /**
     * 用户个人基本信息修改
     *
     * @param userId        用户id
     * @param uGender       性别
     * @param uDOfB         出生日期
     * @param uIntroduction 介绍
     * @param uProvince     省份
     * @param uCity         城市
     * @return
     */
    @ApiOperation("个人基础信息修改接口")
    @RequestMapping(value = "/user/service/basic/info/@change", method = RequestMethod.POST)
    public Map<String, Object> userServiceBasicInfoChange(
            @RequestParam("userId") Long userId,
            @RequestParam("sex") int uGender,
            @RequestParam("str_date_of_birth") String uDOfB,
            @RequestParam("introduction") String uIntroduction,
            @RequestParam("province") String uProvince,
            @RequestParam("city") String uCity
    ) {
        if (userId == null) {
            return this.error("亲，你的ID是空的", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(uDOfB)) {
            return this.error("亲，请填写出生日期", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (!((uGender == UserSex.MALE.value()) || (uGender == UserSex.FEMALE.value())
                || (uGender == UserSex.SECRET.value()))) {
            return this.error("亲，请正确选择性别", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(uProvince)) {
            return this.error("亲，请选择所在省", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(uCity)) {
            return this.error("亲，请选择所在市", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }

        UserDto dto = new UserDto();
        dto.setId(userId);
        // TODO: 强制转换日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        try {
            dateOfBirth = sdf.parse(uDOfB);
        } catch (ParseException e) {
            logger.error("e:{}", e);
        }
        if (dateOfBirth != null) {
            dto.setDateOfBirth(dateOfBirth);
        }
        dto.setIntroduction(uIntroduction);
        dto.setSex((byte) uGender);
        dto.setProvince(uProvince);
        dto.setCity(uCity);

        UserDto userDto = null;
        try {
            userDto = this.userService.userInfoUpdate(dto);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userDto);
    }

    /**
     * 密码更新接口
     *
     * @param userId      用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    @ApiOperation("个人密码修改接口")
    @RequestMapping(value = "/user/service/password/@reset", method = RequestMethod.POST)
    public Map<String, Object> userServicePasswordReset(
            @RequestParam("uId") Long userId,
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword
    ) {
        if (userId == null) {
            return this.error("亲，用户id不能为空！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(oldPassword)) {
            return this.error("亲，原密码不能为空！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(newPassword)) {
            return this.error("亲，新密码不能为空！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        // TODO: 验证原密码是否正确
        User oldUser = null;
        try {
            // 查询用户
            oldUser = this.userMapper.selectByPrimaryKey(userId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (oldUser == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        // 验证原密码是否正确
        if (!ConfusionUtil.pwToMD5(oldPassword, userId).equals(oldUser.getPassword())) {
            return this.error("原密码不正确", ServiceResultType.RESULT_MD5_SYSTEM_ERROR);
        }

        // TODO: 设置新密码
        UserDto userDto = new UserDto();
        userDto.setId(userId);
        userDto.setPassword(ConfusionUtil.pwToMD5(newPassword, userId));
        UserDto userDtoPO = null;
        try {
            userDtoPO = this.userService.userInfoUpdate(userDto);
        } catch (Exception e) {
            logger.error("e:{}!", e);
        }
        if (userDtoPO == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userDtoPO);
    }

    /**
     * 根据用户名模糊搜索接口
     *
     * @param nickname 用户昵称
     * @return
     */
    @ApiOperation("根据用户名模糊搜索接口")
    @RequestMapping(value = "/user/service/find/like/nickname/@query", method = RequestMethod.GET)
    public Map<String, Object> userServiceFindLikeNickname(
            @RequestParam(value = "nickname", required = false) String nickname
    ) {
        if (StringUtils.isBlank(nickname)) {
            return this.error("搜索昵称不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<UserDto> userDtos = null;
        try {
            userDtos = this.userService.findUserLikeNickName(nickname);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userDtos);
    }

    @ApiOperation("根据用户id获取用户页面的基本信息和歌单数量信息的接口")
    @RequestMapping(value = "/show/user/page/info/and/num/of/created/and/collected/@query", method = RequestMethod.GET)
    public Map<String, Object> showUserPageInfoAndNumOfCreatedAndCollected(
            @RequestParam(value = "user_id", required = false) Long userId
    ) {
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        UserAndCreatedMLAndCollectedMLDto userAndCreatedMLAndCollectedMLDto = null;
        try {
            userAndCreatedMLAndCollectedMLDto = this.userService.findUserAndCreatedMLAndCollectedMLByUserId(userId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userAndCreatedMLAndCollectedMLDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userAndCreatedMLAndCollectedMLDto);
    }

    @ApiOperation("重置用户密码接口")
    @RequestMapping(value = "/user/service/password/@forget", method = RequestMethod.POST)
    public Map<String, Object> userServiceForgetResetPassword(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password
    ) {
        if (StringUtils.isBlank(email)) {
            return this.error("邮箱账号不能为空！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(password)) {
            return this.error("亲，密码不能为空！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        // 查询账号
        User user = this.userMapper.selectByEmail(email);
        if (user == null) {
            return this.error("亲，账号不存在！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPassword(ConfusionUtil.pwToMD5(password, user.getId()));

        UserDto userDtoUpdate = null;
        try {
            userDtoUpdate = this.userService.userInfoUpdate(userDto);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userDtoUpdate == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userDtoUpdate);
    }

}
