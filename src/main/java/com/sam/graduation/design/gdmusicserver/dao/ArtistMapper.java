package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.Artist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArtistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Artist record);

    int insertSelective(Artist record);

    Artist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Artist record);

    int updateByPrimaryKey(Artist record);

    List<Artist> selectLikeArtistName(
            @Param("artist_name") String artistName
    );
}