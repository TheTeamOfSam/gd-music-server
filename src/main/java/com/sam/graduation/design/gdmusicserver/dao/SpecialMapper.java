package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.Special;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Special record);

    int insertSelective(Special record);

    Special selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Special record);

    int updateByPrimaryKey(Special record);

    List<Special> selectLikeSpecialName(
            @Param("special_name") String specialName
    );

    List<Special> selectByArtistId(
            @Param("artist_id") Long artistId
    );

}