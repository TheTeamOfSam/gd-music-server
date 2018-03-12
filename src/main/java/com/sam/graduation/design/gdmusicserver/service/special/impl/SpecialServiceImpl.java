package com.sam.graduation.design.gdmusicserver.service.special.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.SpecialDto;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialMapper;
import com.sam.graduation.design.gdmusicserver.dao.SpecialMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecial;
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

    @Override
    public List<SpecialDto> findLikeSpecialName(String specialName) {
        List<SpecialDto> specialDtos = null;

        List<Special> specials = null;
        try {
            specials = this.specialMapper.selectLikeSpecialName(specialName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (specials == null) {
            specialDtos = new ArrayList<SpecialDto>();
            return specialDtos;
        }
        specialDtos = new ArrayList<SpecialDto>();
        for (Special spc : specials) {
            SpecialDto specialDto = new SpecialDto();
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
            logger.error("e:{}",e);
        }
        if (artistSpecials == null) {
            artistSpecialDtos = new ArrayList<ArtistSpecialDto>();
            return artistSpecialDtos;
        }
        artistSpecialDtos = new ArrayList<ArtistSpecialDto>();
        for (ArtistSpecial as: artistSpecials){
            ArtistSpecialDto artistSpecialDto = new ArtistSpecialDto();
            artistSpecialDto.from(as);
            artistSpecialDtos.add(artistSpecialDto);
        }
        return artistSpecialDtos;
    }
}
