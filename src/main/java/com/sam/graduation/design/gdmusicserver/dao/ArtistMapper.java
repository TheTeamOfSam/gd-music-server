package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.Artist;

public interface ArtistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Artist record);

    int insertSelective(Artist record);

    Artist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Artist record);

    int updateByPrimaryKey(Artist record);
}