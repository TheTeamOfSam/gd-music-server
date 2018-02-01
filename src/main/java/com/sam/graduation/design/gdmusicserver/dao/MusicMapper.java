package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.Music;

public interface MusicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
}