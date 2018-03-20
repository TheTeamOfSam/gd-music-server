package com.sam.graduation.design.gdmusicserver.service.music.list.collection.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicListCollectionDto;
import com.sam.graduation.design.gdmusicserver.controller.pub.AppException;
import com.sam.graduation.design.gdmusicserver.dao.MusicListCollectionMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicListCollection;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.music.list.collection.MusicListCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/20 17:05:10
 */
@Service
public class MusicListCollectionServiceImpl extends BaseService implements MusicListCollectionService {

    private static final String FILE_SEPARATOR = File.separator;

    @Value("${url.link}")
    private String urlLink;

    @Autowired
    private MusicListCollectionMapper musicListCollectionMapper;

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
}
