package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.MusicListCollection;
import org.apache.ibatis.annotations.Param;

public interface MusicListCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MusicListCollection record);

    int insertSelective(MusicListCollection record);

    MusicListCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MusicListCollection record);

    int updateByPrimaryKey(MusicListCollection record);

    MusicListCollection selectMusicListCollectionByUserIdAndUserMusicListId(
            @Param("user_id") Long userId,
            @Param("user_music_list_id") Long userMusicListId
    );
}