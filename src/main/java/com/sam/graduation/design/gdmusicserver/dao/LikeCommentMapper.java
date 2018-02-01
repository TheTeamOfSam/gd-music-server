package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.LikeComment;

public interface LikeCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LikeComment record);

    int insertSelective(LikeComment record);

    LikeComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LikeComment record);

    int updateByPrimaryKey(LikeComment record);
}