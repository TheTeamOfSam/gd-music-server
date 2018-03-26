package com.sam.graduation.design.gdmusicserver.service.special.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialAndNumOfMusicInSpecialDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.SpecialDto;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialAndNumOfMusicInSpecialMapper;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialMapper;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialMusicMapper;
import com.sam.graduation.design.gdmusicserver.dao.SpecialMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecial;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialAndNumOfMusicInSpecial;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialMusic;
import com.sam.graduation.design.gdmusicserver.model.pojo.Special;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.special.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 14:43:01
 */
@Service
public class SpecialServiceImpl extends BaseService implements SpecialService {

    @Autowired
    private SpecialMapper specialMapper;

    @Autowired
    private ArtistSpecialMapper artistSpecialMapper;

    @Autowired
    private ArtistSpecialMusicMapper artistSpecialMusicMapper;

    @Autowired
    private ArtistSpecialAndNumOfMusicInSpecialMapper artistSpecialAndNumOfMusicInSpecialMapper;

    @Override
    public List<ArtistSpecialMusicDto> findLikeSpecialName(String specialName) {
        List<ArtistSpecialMusicDto> specialDtos = null;

        List<ArtistSpecialMusic> specials = null;
        try {
            specials = this.artistSpecialMusicMapper.selectLikeSpecialName(specialName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (specials == null) {
            specialDtos = new ArrayList<ArtistSpecialMusicDto>();
            return specialDtos;
        }
        specialDtos = new ArrayList<ArtistSpecialMusicDto>();
        for (ArtistSpecialMusic spc : specials) {
            ArtistSpecialMusicDto specialDto = new ArtistSpecialMusicDto();
            specialDto.from(spc);
            specialDtos.add(specialDto);
        }
        return specialDtos;
    }

    @Override
    public List<ArtistSpecialDto> findASLikeSpecialName(String specialName) {
        List<ArtistSpecialDto> artistSpecialDtos = null;

        List<ArtistSpecial> artistSpecials = null;
        try {
            artistSpecials = this.artistSpecialMapper.selectLikeSpecialName(specialName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecials == null) {
            artistSpecialDtos = new ArrayList<ArtistSpecialDto>();
            return artistSpecialDtos;
        }
        artistSpecialDtos = new ArrayList<ArtistSpecialDto>();
        for (ArtistSpecial as : artistSpecials) {
            ArtistSpecialDto artistSpecialDto = new ArtistSpecialDto();
            artistSpecialDto.from(as);
            artistSpecialDtos.add(artistSpecialDto);
        }
        return artistSpecialDtos;
    }

    @Override
    public List<SpecialDto> findByArtistId(Long artistId) {
        List<SpecialDto> specialDtos = null;

        List<Special> specials = null;
        try {
            specials = this.specialMapper.selectByArtistId(artistId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (specials == null) {
            specialDtos = new ArrayList<SpecialDto>();
            return specialDtos;
        }
        specialDtos = new ArrayList<SpecialDto>();
        for (Special special : specials) {
            SpecialDto specialDto = new SpecialDto();
            specialDto.from(special);
            specialDtos.add(specialDto);
        }
        return specialDtos;
    }

    @Override
    public ArtistSpecialAndNumOfMusicInSpecialDto findBySpecialId(Long specialId) {
        ArtistSpecialAndNumOfMusicInSpecialDto artistSpecialAndNumOfMusicInSpecialDto = null;

        ArtistSpecialAndNumOfMusicInSpecial artistSpecialAndNumOfMusicInSpecial = null;
        try {
            artistSpecialAndNumOfMusicInSpecial = this.artistSpecialAndNumOfMusicInSpecialMapper.selectBySpecialId(specialId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialAndNumOfMusicInSpecial == null) {
            return artistSpecialAndNumOfMusicInSpecialDto;
        }
        artistSpecialAndNumOfMusicInSpecialDto = new ArtistSpecialAndNumOfMusicInSpecialDto();
        artistSpecialAndNumOfMusicInSpecialDto.from(artistSpecialAndNumOfMusicInSpecial);
        return artistSpecialAndNumOfMusicInSpecialDto;
    }

    @Override
    public List<ArtistSpecialMusicDto> findMusicInSpecialBySpecialId(Long specialId) {
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;

        List<ArtistSpecialMusic> artistSpecialMusics = null;
        try {
            artistSpecialMusics = this.artistSpecialMusicMapper.selectMusicInSpecialBySpecialId(specialId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusics == null) {
            return artistSpecialMusicDtos;
        }
        artistSpecialMusicDtos =new ArrayList<ArtistSpecialMusicDto>();
        for (ArtistSpecialMusic asm: artistSpecialMusics) {
            ArtistSpecialMusicDto artistSpecialMusicDto = new ArtistSpecialMusicDto();
            artistSpecialMusicDto.from(asm);
            artistSpecialMusicDtos.add(artistSpecialMusicDto);
        }
        return artistSpecialMusicDtos;
    }
}
