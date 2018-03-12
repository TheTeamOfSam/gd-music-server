package com.sam.graduation.design.gdmusicserver.service.music;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 16:44:50
 */
public interface MusicService {

    MessageDto oneBtnToUpdateDuration();

    List<ArtistSpecialMusicDto> findLikeMusicName(String musicName);

}
