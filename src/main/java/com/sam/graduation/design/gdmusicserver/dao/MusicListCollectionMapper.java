package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.MusicListCollection;

public interface MusicListCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MusicListCollection record);

    int insertSelective(MusicListCollection record);

    MusicListCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MusicListCollection record);

    int updateByPrimaryKey(MusicListCollection record);
}