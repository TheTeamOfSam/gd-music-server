package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.MusicComment;

public interface MusicCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MusicComment record);

    int insertSelective(MusicComment record);

    MusicComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MusicComment record);

    int updateByPrimaryKey(MusicComment record);
}