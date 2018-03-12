package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 15:08:44
 */
public interface ArtistSpecialMapper {

    List<ArtistSpecial> selectLikeSpecialName(
            @Param("special_name") String specialName
    );

}
