package com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialMusicMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialMusic;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list.MusicInUserMusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/17 15:50:56
 */
@Service
public class MusicInUserMusicListServiceImpl extends BaseService implements MusicInUserMusicListService {

    @Autowired
    private ArtistSpecialMusicMapper artistSpecialMusicMapper;

    @Override
    public List<ArtistSpecialMusicDto> showMyMusicList(Long userId, Long musicListId) {
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;

        List<ArtistSpecialMusic> artistSpecialMusics = null;
        try {
            artistSpecialMusics = this.artistSpecialMusicMapper.selectMyMusicList(userId, musicListId);
        } catch (Exception e) {
            logger.error("e:{}",e);
        }
        if (artistSpecialMusics == null) {
            artistSpecialMusicDtos = new ArrayList<ArtistSpecialMusicDto>();
            return artistSpecialMusicDtos;
        }
        artistSpecialMusicDtos = new ArrayList<ArtistSpecialMusicDto>();
        for (ArtistSpecialMusic asm: artistSpecialMusics) {
            ArtistSpecialMusicDto artistSpecialMusicDto = new ArtistSpecialMusicDto();
            artistSpecialMusicDto.from(asm);
            artistSpecialMusicDtos.add(artistSpecialMusicDto);
        }
        return artistSpecialMusicDtos;
    }
}
