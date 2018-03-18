package com.sam.graduation.design.gdmusicserver.service.artist.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistDto;
import com.sam.graduation.design.gdmusicserver.dao.ArtistMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.Artist;
import com.sam.graduation.design.gdmusicserver.service.artist.ArtistService;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 13:43:21
 */
@Service
public class ArtistServiceImpl extends BaseService implements ArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    @Override
    public List<ArtistDto> findLikeArtistName(String artistName) {
        List<ArtistDto> artistDtos = null;

        List<Artist> artists = null;
        try {
            artists = this.artistMapper.selectLikeArtistName(artistName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artists == null) {
            artistDtos = new ArrayList<ArtistDto>();
            return artistDtos;
        }
        artistDtos = new ArrayList<ArtistDto>();
        for (Artist ats : artists) {
            ArtistDto artistDto = new ArtistDto();
            artistDto.from(ats);
            artistDtos.add(artistDto);
        }
        return artistDtos;
    }

    @Override
    public ArtistDto findByArtistId(Long artistId) {

        ArtistDto artistDto = null;

        Artist artist = null;
        try {
            artist = this.artistMapper.selectByPrimaryKey(artistId);
        } catch (Exception e) {
            logger.error("e:{}",e);
        }
        if (artist == null) {
//            return artistDto;
        }
        artistDto = new ArtistDto();
        artistDto.from(artist);
        return artistDto;
    }
}
