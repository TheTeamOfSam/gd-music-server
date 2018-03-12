package com.sam.graduation.design.gdmusicserver.service.user.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserDto;
import com.sam.graduation.design.gdmusicserver.dao.UserMapper;
import com.sam.graduation.design.gdmusicserver.model.enums.related.UserSex;
import com.sam.graduation.design.gdmusicserver.model.pojo.User;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.user.UserService;
import com.sam.graduation.design.gdmusicserver.utils.ConfusionUtil;
import com.sam.graduation.design.gdmusicserver.utils.GDMSFileUtils;
import com.sam.graduation.design.gdmusicserver.utils.image.cut.ImageBean;
import com.sam.graduation.design.gdmusicserver.utils.image.cut.ImageCut;
import com.sam.graduation.design.gdmusicserver.utils.image.cut.ImageCutInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/2/28 15:18:21
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    private static String FILE_SEPARATOR = File.separator;

    // 链接头
    @Value("${url.link}")
    private String urlLink;

    // 存储头像路径
    @Value("${head.image.path}")
    private String headImagePath;

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
        if (userPO != null) {
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
        UserDto userDto = null;

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

    @Override
    public UserDto userInfoGet(Long userID) {
        UserDto userDto = null;
        User user = this.userMapper.selectByPrimaryKey(userID);
        if (user == null) {
            return userDto;
        }
        userDto = new UserDto();
        userDto.from(user);
        userDto.setPassword(null);
        userDto.setHeadPhoto(urlLink + FILE_SEPARATOR + user.getHeadPhoto());
        return userDto;
    }

    @Override
    public UserDto userInfoUpdate(UserDto dto) {
        UserDto userDto = null;

        User user = dto.to();
        user.setId(dto.getId());
        user.setLastModifiedTime(new Date());

        int updateResult = 0;
        try {
            updateResult = this.userMapper.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            logger.error("e:{}!", e);
        }
        if (updateResult == 0) {
            return userDto;
        }
        userDto = new UserDto();
        userDto.from(user);
        return userDto;
    }

    @Override
    public MessageDto userHeadPhotoUpdate(Long userID, MultipartFile headPhoto) {

        BufferedImage bi = null;

//        // TODO: 删除服务器上的老头像
//        User userGet = this.userMapper.selectByPrimaryKey(userID);
//        String hpOldRelPath = userGet.getHeadPhoto();
//        File hpOldFile = Paths.get(headImagePath, hpOldRelPath).toFile();
//        FileUtils.deleteQuietly(hpOldFile);

        // TODO: 计算图片切割点位
        try {
            bi = ImageIO.read(headPhoto.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bi == null) {
            MessageDto messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("图片解析错误");
            return messageDto;
        }

        ImageBean imageBean = ImageCutInfo.getImageCutInfo(bi.getWidth(), bi.getHeight());
        if (imageBean == null) {
            MessageDto messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("图片切割点位获取错误");
            return messageDto;
        }

        // TODO: 切割并存储图片
        String hpOraName = headPhoto.getOriginalFilename();
        String hpFormat = hpOraName.toLowerCase().substring(hpOraName.lastIndexOf("."), hpOraName.length())
                .toLowerCase();
        String hpRelPath = null;

        try {
            String hpDescPath = headImagePath + FILE_SEPARATOR + "head" + FILE_SEPARATOR + "image" + FILE_SEPARATOR +
                    GDMSFileUtils.getTimePath() + FILE_SEPARATOR + userID + FILE_SEPARATOR;
            File hpDescDir = Paths.get(hpDescPath).toFile();
            FileUtils.forceMkdir(hpDescDir);
            ImageCut.cut((FileInputStream) headPhoto.getInputStream(), hpDescPath, imageBean, hpFormat.substring(
                    hpFormat.lastIndexOf(".") + 1, hpFormat.length()));
            hpRelPath = "head" + FILE_SEPARATOR + "image" + FILE_SEPARATOR + GDMSFileUtils.getTimePath() +
                    FILE_SEPARATOR + userID + FILE_SEPARATOR + imageBean.getName() + hpFormat;
        } catch (IOException e) {
            logger.error("e:{}.", e);
        }

        if (StringUtils.isBlank(hpRelPath)) {
            MessageDto messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("图片切割操作错误");
            return messageDto;
        }

        // TODO: 更新数据库中用户的头像数据
        User userUpdate = new User();
        userUpdate.setId(userID);
        userUpdate.setHeadPhoto(hpRelPath);
        userUpdate.setLastModifiedTime(new Date());

        int updateResult = 0;
        try {
            updateResult = this.userMapper.updateByPrimaryKeySelective(userUpdate);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (updateResult == 0) {
            MessageDto messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("更新用户头像数据错误");
            return messageDto;
        }

        MessageDto messageDto = new MessageDto();
        messageDto.setMessage("成功");
        messageDto.setSuccess(true);
        return messageDto;
    }

}
