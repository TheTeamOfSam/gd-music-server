package com.sam.graduation.design.gdmusicserver.service.user.music.list;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicListDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserUserMusicListAndMusicInItDto;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/13 19:04:01
 */
public interface UserMusicListService {

    MessageDto userMusicListCreate(UserMusicListDto userMusicListDto);

    List<UserUserMusicListAndMusicInItDto> findListUserMusicListName(String userMusicListName);

    List<UserUserMusicListAndMusicInItDto> findUserMusicListByUserId(Long userID);

    UserMusicListDto findUserMusicListByUserMusicListId(Long userMusicListId);

}
