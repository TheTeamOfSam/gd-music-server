package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicList;

public interface UserMusicListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserMusicList record);

    int insertSelective(UserMusicList record);

    UserMusicList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserMusicList record);

    int updateByPrimaryKey(UserMusicList record);
}