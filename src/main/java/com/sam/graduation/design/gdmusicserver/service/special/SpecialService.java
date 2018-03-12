package com.sam.graduation.design.gdmusicserver.service.special;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.SpecialDto;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 14:42:33
 */
public interface SpecialService {

    List<SpecialDto> findLikeSpecialName(String specialName);

    List<ArtistSpecialDto> findASLikeSpecialName(String specialName);


}
