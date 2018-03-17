package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.MusicInUserMusicList;
import org.apache.ibatis.annotations.Param;

public interface MusicInUserMusicListMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByUserMusicListId(
            @Param("user_music_list_id") Long userMusicListId
    );

    int insert(MusicInUserMusicList record);

    int insertSelective(MusicInUserMusicList record);

    MusicInUserMusicList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MusicInUserMusicList record);

    int updateByPrimaryKey(MusicInUserMusicList record);
}