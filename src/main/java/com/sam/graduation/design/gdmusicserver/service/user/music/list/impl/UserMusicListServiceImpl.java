package com.sam.graduation.design.gdmusicserver.service.user.music.list.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicListDto;
import com.sam.graduation.design.gdmusicserver.dao.UserMusicListMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicList;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.user.music.list.UserMusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/13 19:08:12
 */
@Service
public class UserMusicListServiceImpl extends BaseService implements UserMusicListService {

    @Autowired
    private UserMusicListMapper userMusicListMapper;

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
}
