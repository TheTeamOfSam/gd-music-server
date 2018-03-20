package com.sam.graduation.design.gdmusicserver.service.music.list.collection.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicListCollectionDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserUserMusicListAndMusicInItDto;
import com.sam.graduation.design.gdmusicserver.controller.pub.AppException;
import com.sam.graduation.design.gdmusicserver.dao.MusicListCollectionMapper;
import com.sam.graduation.design.gdmusicserver.dao.UserUserMusicListAndMusicInItMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicListCollection;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserUserMusicListAndMusicInIt;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.music.list.collection.MusicListCollectionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/20 17:05:10
 */
@Service
public class MusicListCollectionServiceImpl extends BaseService implements MusicListCollectionService {

    private static final String FILE_SEPARATOR = File.separator;

    @Value("${url.link}")
    private String urlLink;

    @Value("${blank.user.music.list.photo.url.link}")
    private String blankUserMusicListPhotoUrlLink;

    @Value("${default.head.photo}")
    private String defaultHeadPhoto;

    @Autowired
    private MusicListCollectionMapper musicListCollectionMapper;

    @Autowired
    private UserUserMusicListAndMusicInItMapper userUserMusicListAndMusicInItMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto collectOtherUserMusicListIntoMyCollect(MusicListCollectionDto musicListCollectionDto) {
        MessageDto messageDto = null;

        MusicListCollection musicListCollection = musicListCollectionDto.to();
        int collectMusicListResult = 0;
        try {
            collectMusicListResult = this.musicListCollectionMapper.insertSelective(musicListCollection);
        } catch (Exception e) {
            logger.error("e:{}", e);
            throw new AppException("收藏歌单异常");
        }
        if (collectMusicListResult == 0) {
            messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("收藏歌单错误");
            return messageDto;
        }
        messageDto = new MessageDto();
        messageDto.setSuccess(true);
        messageDto.setMessage("收藏歌单成功");
        return messageDto;
    }

    @Override
    public List<UserUserMusicListAndMusicInItDto> showMyCollectByUserId(Long userId) {
        List<UserUserMusicListAndMusicInItDto> userUserMusicListAndMusicInItDtos = null;

        List<UserUserMusicListAndMusicInIt> userUserMusicListAndMusicInIts = null;
        try {
            userUserMusicListAndMusicInIts = this.userUserMusicListAndMusicInItMapper
                    .selectMusicListCollectionByUserId(userId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userUserMusicListAndMusicInIts == null || userUserMusicListAndMusicInIts.size() == 0) {
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
