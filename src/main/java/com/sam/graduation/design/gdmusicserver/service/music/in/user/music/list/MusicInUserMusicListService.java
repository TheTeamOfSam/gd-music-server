package com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/17 15:50:32
 */
public interface MusicInUserMusicListService {

    List<ArtistSpecialMusicDto> showMyMusicList(Long userId, Long musicListId);

    List<ArtistSpecialMusicDto> findMusicByUserMusicListId(Long userMusicListId);

}
