package com.sam.graduation.design.gdmusicserver.service.music.list.collection;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicListCollectionDto;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/20 17:04:43
 */
public interface MusicListCollectionService {

    MessageDto collectOtherUserMusicListIntoMyCollect(
            MusicListCollectionDto musicListCollectionDto
    );

}
