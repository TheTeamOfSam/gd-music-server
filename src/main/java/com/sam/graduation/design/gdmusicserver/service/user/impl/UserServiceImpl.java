package com.sam.graduation.design.gdmusicserver.service.user.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.UserDto;
import com.sam.graduation.design.gdmusicserver.dao.UserMapper;
import com.sam.graduation.design.gdmusicserver.model.enums.related.UserSex;
import com.sam.graduation.design.gdmusicserver.model.pojo.User;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.user.UserService;
import com.sam.graduation.design.gdmusicserver.utils.ConfusionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/2/28 15:18:21
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public UserDto userRegister(UserDto dto) {

        UserDto userDto = null;

        // TODO: 将对象初始化后保存到数据库
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setNickname(dto.getNickname());
        user.setPassword("");
        user.setIntroduction("");
        if (dto.getSex() == UserSex.MALE.value()) {
            user.setSex((byte) UserSex.MALE.value());
        } else if (dto.getSex() == UserSex.FEMALE.value()) {
            user.setSex((byte) UserSex.FEMALE.value());
        } else if (dto.getSex() == UserSex.SECRET.value()) {
            user.setSex((byte) UserSex.SECRET.value());
        }
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setProvince(dto.getProvince());
        user.setCity(dto.getCity());
        user.setHeadPhoto("");
        user.setCreatedTime(new Date());
        user.setLastModifiedTime(new Date());
        user.setIsDelete((byte) 0);
        // TODO: 保存第一步注册
        int firstRegistResult = this.userMapper.insertSelective(user);
        if (firstRegistResult == 0) { // 失败则返回
            return userDto;
        }

        // TODO: 筛选出来进行MD5加盐
        User userPO = this.userMapper.selectByEmail(dto.getEmail());
        if (userPO!=null) {
            userPO.setPassword(ConfusionUtil.pwToMD5(dto.getPassword(), userPO.getId()));
        } else {
            return userDto;
        }

        int updateResult = this.userMapper.updateByPrimaryKeySelective(userPO);
        if (updateResult == 0) {
            return userDto;
        }
        UserDto userDtoReturn = new UserDto();
        userDtoReturn.from(userPO);
        return userDtoReturn;
    }

    @Override
    public UserDto userLogin(UserDto dto) {
        UserDto userDto=null;

        // TODO: 先找出对应账号
        User lUser = dto.to();
        User user = this.userMapper.selectByEmailAndPassword(lUser);
        if (user == null) {
            return userDto;
        }
        userDto = new UserDto();
        userDto.from(user);
        return userDto;
    }
}
