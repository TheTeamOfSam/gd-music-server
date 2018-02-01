package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.MusicInUserMusicList;

public interface MusicInUserMusicListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MusicInUserMusicList record);

    int insertSelective(MusicInUserMusicList record);

    MusicInUserMusicList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MusicInUserMusicList record);

    int updateByPrimaryKey(MusicInUserMusicList record);
}