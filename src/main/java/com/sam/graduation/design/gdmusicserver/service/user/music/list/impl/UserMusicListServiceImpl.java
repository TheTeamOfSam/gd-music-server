package com.sam.graduation.design.gdmusicserver.service.user.music.list.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicListDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserUserMusicListAndMusicInItDto;
import com.sam.graduation.design.gdmusicserver.dao.UserMusicListMapper;
import com.sam.graduation.design.gdmusicserver.dao.UserUserMusicListAndMusicInItMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicList;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserUserMusicListAndMusicInIt;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.user.music.list.UserMusicListService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/13 19:08:12
 */
@Service
public class UserMusicListServiceImpl extends BaseService implements UserMusicListService {

    private static final String FILE_SEPARATOR = File.separator;

    @Value("${url.link}")
    private String urlLink;

    @Value("${blank.user.music.list.photo.url.link}")
    private String blankUserMusicListPhotoUrlLink;

    @Value("${default.head.photo}")
    private String defaultHeadPhoto;

    @Autowired
    private UserMusicListMapper userMusicListMapper;

    @Autowired
    private UserUserMusicListAndMusicInItMapper userUserMusicListAndMusicInItMapper;

    @Override
    public MessageDto userMusicListCreate(UserMusicListDto userMusicListDto) {
        MessageDto dto = null;

        UserMusicList userMusicList = userMusicListDto.to();
        userMusicList.setCreatedTime(new Date());
        userMusicList.setLastModifiedTime(new Date());
        userMusicList.setIsDelete((byte) 0);

        int insertResult = 0;
        try {
            insertResult = this.userMusicListMapper.insertSelective(userMusicList);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (insertResult == 0) {
            dto = new MessageDto();
            dto.setSuccess(false);
            dto.setMessage("创建歌单失败");
            return dto;
        }
        dto = new MessageDto();
        dto.setSuccess(true);
        dto.setMessage("创建歌单成功");
        return dto;
    }

    @Override
    public List<UserUserMusicListAndMusicInItDto> findListUserMusicListName(String userMusicListName) {
        List<UserUserMusicListAndMusicInItDto> userUserMusicListAndMusicInItDtos = null;

        List<UserUserMusicListAndMusicInIt> userUserMusicListAndMusicInIts = null;
        try {
            userUserMusicListAndMusicInIts = this.userUserMusicListAndMusicInItMapper.selectLikeUserMusicListName(userMusicListName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userUserMusicListAndMusicInIts == null) {
            userUserMusicListAndMusicInItDtos = new ArrayList<UserUserMusicListAndMusicInItDto>();
            return userUserMusicListAndMusicInItDtos;
        }
        userUserMusicListAndMusicInItDtos = new ArrayList<UserUserMusicListAndMusicInItDto>();
        for (UserUserMusicListAndMusicInIt userUserMusicListAndMusicInIt : userUserMusicListAndMusicInIts) {
            UserUserMusicListAndMusicInItDto userUserMusicListAndMusicInItDto = new UserUserMusicListAndMusicInItDto();
            userUserMusicListAndMusicInItDto.from(userUserMusicListAndMusicInIt);
            if (StringUtils.isBlank(userUserMusicListAndMusicInIt.getUserMusicListPhoto())) {
                userUserMusicListAndMusicInItDto.setUserMusicListPhoto(blankUserMusicListPhotoUrlLink);
            } else {
                userUserMusicListAndMusicInItDto.setUserMusicListPhoto(userUserMusicListAndMusicInIt.getUserMusicListPhoto());
            }
            if (StringUtils.isBlank(userUserMusicListAndMusicInIt.getUserHeadPhoto())) {
                userUserMusicListAndMusicInItDto.setUserHeadPhoto(defaultHeadPhoto);
            } else {
                userUserMusicListAndMusicInItDto.setUserHeadPhoto(urlLink + FILE_SEPARATOR + userUserMusicListAndMusicInIt.getUserHeadPhoto());
            }
            userUserMusicListAndMusicInItDtos.add(userUserMusicListAndMusicInItDto);
        }
        return userUserMusicListAndMusicInItDtos;
    }

    @Override
    public List<UserUserMusicListAndMusicInItDto> findUserMusicListByUserId(Long userID) {
        List<UserUserMusicListAndMusicInItDto> userUserMusicListAndMusicInItDtos = null;

        List<UserUserMusicListAndMusicInIt> userUserMusicListAndMusicInIts = null;
        try {
            userUserMusicListAndMusicInIts = this.userUserMusicListAndMusicInItMapper.selectByUserId(userID);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userUserMusicListAndMusicInIts == null) {
            userUserMusicListAndMusicInItDtos = new ArrayList<UserUserMusicListAndMusicInItDto>();
            return userUserMusicListAndMusicInItDtos;
        }
        userUserMusicListAndMusicInItDtos = new ArrayList<UserUserMusicListAndMusicInItDto>();
        for (UserUserMusicListAndMusicInIt uumlamii : userUserMusicListAndMusicInIts) {
            UserUserMusicListAndMusicInItDto uumlamiiDto = new UserUserMusicListAndMusicInItDto();
            uumlamiiDto.from(uumlamii);
            if (StringUtils.isBlank(uumlamii.getUserMusicListPhoto())) {
                uumlamiiDto.setUserMusicListPhoto(blankUserMusicListPhotoUrlLink);
            } else {
                uumlamiiDto.setUserMusicListPhoto(uumlamii.getUserMusicListPhoto());
            }
            if (StringUtils.isBlank(uumlamii.getUserHeadPhoto())) {
                uumlamiiDto.setUserHeadPhoto(defaultHeadPhoto);
            } else {
                uumlamiiDto.setUserHeadPhoto(urlLink + FILE_SEPARATOR + uumlamii.getUserHeadPhoto());
            }
            userUserMusicListAndMusicInItDtos.add(uumlamiiDto);
        }
        return userUserMusicListAndMusicInItDtos;
    }
}
