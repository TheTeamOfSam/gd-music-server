package com.sam.graduation.design.gdmusicserver.service.music.list.collection;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicListCollectionDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserUserMusicListAndMusicInItDto;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/20 17:04:43
 */
public interface MusicListCollectionService {

    MessageDto collectOtherUserMusicListIntoMyCollect(
            MusicListCollectionDto musicListCollectionDto
    );

    List<UserUserMusicListAndMusicInItDto> showMyCollectByUserId(
            Long userId
    );

}
