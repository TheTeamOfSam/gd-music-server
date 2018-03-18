package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialAndNumOfMusicInSpecial;
import org.apache.ibatis.annotations.Param;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 14:17:27
 */
public interface ArtistSpecialAndNumOfMusicInSpecialMapper {

    ArtistSpecialAndNumOfMusicInSpecial selectBySpecialId(
            @Param("special_id") Long specialId
    );

}
