package com.sam.graduation.design.gdmusicserver.service.user.music.list.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicInUserMusicListDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicListDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserUserMusicListAndMusicInItDto;
import com.sam.graduation.design.gdmusicserver.controller.pub.AppException;
import com.sam.graduation.design.gdmusicserver.dao.*;
import com.sam.graduation.design.gdmusicserver.model.pojo.*;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.user.music.list.UserMusicListService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    private ArtistMapper artistMapper;

    @Autowired
    private SpecialMapper specialMapper;

    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private UserMusicListMapper userMusicListMapper;

    @Autowired
    private UserUserMusicListAndMusicInItMapper userUserMusicListAndMusicInItMapper;

    @Autowired
    private MusicInUserMusicListMapper musicInUserMusicListMapper;

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

    @Override
    public UserMusicListDto findUserMusicListByUserMusicListId(Long userMusicListId) {
        UserMusicListDto userMusicListDto = null;
        UserMusicList userMusicList = null;

        try {
            userMusicList = this.userMusicListMapper.selectByPrimaryKey(userMusicListId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userMusicList == null) {
            return userMusicListDto;
        }
        userMusicListDto = new UserMusicListDto();
        userMusicListDto.from(userMusicList);
        if (StringUtils.isBlank(userMusicList.getMusicListPhoto())) {
            userMusicListDto.setMusicListPhoto(blankUserMusicListPhotoUrlLink);
        } else {
            userMusicListDto.setMusicListPhoto(userMusicList.getMusicListPhoto());
        }
        return userMusicListDto;
    }

    @Override
    public MessageDto userMusicListUpdate(UserMusicListDto userMusicListDto) {
        MessageDto messageDto = null;

        UserMusicList userMusicList = userMusicListDto.to();
        userMusicList.setId(userMusicListDto.getId());
        userMusicList.setLastModifiedTime(new Date());

        int updateResult = 0;

        try {
            updateResult = this.userMusicListMapper.updateByPrimaryKeySelective(userMusicList);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (updateResult == 0) {
            messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("歌单更新失败");
            return messageDto;
        }
        messageDto = new MessageDto();
        messageDto.setSuccess(true);
        messageDto.setMessage("歌单更新成功");
        return messageDto;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto userMusicListDelete(Long userMusicListId) {
        MessageDto messageDto = null;
        int deleteUserMusicListResult;
        int deleteMusicInUserMusicListResult;
        try {
            deleteUserMusicListResult = this.userMusicListMapper.deleteByPrimaryKey(userMusicListId);
            deleteMusicInUserMusicListResult = this.musicInUserMusicListMapper.deleteByUserMusicListId(userMusicListId);
        } catch (Exception e) {
            logger.error("e:{}", e);
            throw new AppException("删除歌单内歌曲和歌单出错！");
        }
        if (deleteUserMusicListResult == 0) {
            messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("删除歌单错误！");
            return messageDto;
        }
        if (deleteMusicInUserMusicListResult == 0) {

        } else {

        }
        messageDto = new MessageDto();
        messageDto.setSuccess(true);
        messageDto.setMessage("删除成功");
        return messageDto;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto collectMusicIntoUserMusicList(MusicInUserMusicListDto musicInUserMusicListDto) {
        MessageDto messageDto = null;

        Music music = this.musicMapper.selectByPrimaryKey(musicInUserMusicListDto.getMusicId());
        Special special = this.specialMapper.selectByPrimaryKey(music.getSpecialId());

        MusicInUserMusicList musicInUserMusicList = musicInUserMusicListDto.to();
        musicInUserMusicList.setCollectedTime(new Date());
        musicInUserMusicList.setCreatedTime(new Date());
        musicInUserMusicList.setLastModifiedTime(new Date());
        musicInUserMusicList.setIsDelete((byte) 0);

        UserMusicList userMusicList = new UserMusicList();
        userMusicList.setId(musicInUserMusicList.getUserMusicListId());
        userMusicList.setMusicListPhoto(special.getSpecialPhoto());
        userMusicList.setLastModifiedTime(new Date());

        int collectResult;

        try {
            collectResult = this.musicInUserMusicListMapper.insertSelective(musicInUserMusicList);
            this.userMusicListMapper.updateByPrimaryKeySelective(userMusicList);
        } catch (Exception e) {
            logger.error("e:{}",e);
            throw new AppException("收藏音乐异常");
        }
        if (collectResult == 0) {
            messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("收藏歌曲错误");
            return messageDto;
        }
        messageDto = new MessageDto();
        messageDto.setSuccess(true);
        messageDto.setMessage("收藏歌曲成功");
        return messageDto;
    }
}
