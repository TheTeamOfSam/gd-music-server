package com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialMusicMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialMusic;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list.MusicInUserMusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/17 15:50:56
 */
@Service
public class MusicInUserMusicListServiceImpl extends BaseService implements MusicInUserMusicListService {

    private static final String FILE_SEP = File.separator;

    @Value("${url.link}")
    private String urlLink;

    @Autowired
    private ArtistSpecialMusicMapper artistSpecialMusicMapper;

    @Override
    public List<ArtistSpecialMusicDto> showMyMusicList(Long userId, Long musicListId) {
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;

        List<ArtistSpecialMusic> artistSpecialMusics = null;
        try {
            artistSpecialMusics = this.artistSpecialMusicMapper.selectMyMusicList(userId, musicListId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusics == null) {
            artistSpecialMusicDtos = new ArrayList<ArtistSpecialMusicDto>();
            return artistSpecialMusicDtos;
        }
        artistSpecialMusicDtos = new ArrayList<ArtistSpecialMusicDto>();
        for (ArtistSpecialMusic asm : artistSpecialMusics) {
            ArtistSpecialMusicDto artistSpecialMusicDto = new ArtistSpecialMusicDto();
            artistSpecialMusicDto.from(asm);
            artistSpecialMusicDtos.add(artistSpecialMusicDto);
        }
        return artistSpecialMusicDtos;
    }

    @Override
    public List<ArtistSpecialMusicDto> findMusicByUserMusicListId(Long userMusicListId) {

        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;

        List<ArtistSpecialMusic> artistSpecialMusics = null;

        try {
            artistSpecialMusics = this.artistSpecialMusicMapper.selectMusicByUserMusicListId(userMusicListId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusics == null) {
            artistSpecialMusicDtos = new ArrayList<ArtistSpecialMusicDto>();
            return artistSpecialMusicDtos;
        }
        artistSpecialMusicDtos = new ArrayList<ArtistSpecialMusicDto>();
        for (ArtistSpecialMusic artistSpecialMusic : artistSpecialMusics) {
            ArtistSpecialMusicDto artistSpecialMusicDto = new ArtistSpecialMusicDto();
            artistSpecialMusicDto.from(artistSpecialMusic);
            artistSpecialMusicDto.setMusicPath(urlLink + FILE_SEP + artistSpecialMusic.getMusicPath());
            artistSpecialMusicDtos.add(artistSpecialMusicDto);
        }
        return artistSpecialMusicDtos;
    }
}
