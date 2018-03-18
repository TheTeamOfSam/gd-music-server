package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialMusic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 21:27:33
 */
public interface ArtistSpecialMusicMapper {

    List<ArtistSpecialMusic> selectLikeMusicName(
            @Param("music_name") String musicName
    );

    List<ArtistSpecialMusic> selectMyMusicList(
            @Param("user_id") Long userId,
            @Param("user_music_list_id") Long userMusicListId
    );

    List<ArtistSpecialMusic> selectMusicInSpecialBySpecialId(
            @Param("special_id") Long specialId
    );

}
