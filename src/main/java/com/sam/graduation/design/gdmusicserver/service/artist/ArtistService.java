package com.sam.graduation.design.gdmusicserver.service.artist;

import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistDto;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 13:42:55
 */
public interface ArtistService {

    List<ArtistDto> findLikeArtistName(String artistName);

}
