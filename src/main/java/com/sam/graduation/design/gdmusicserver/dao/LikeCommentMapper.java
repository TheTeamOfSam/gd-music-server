package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.LikeComment;
import org.apache.ibatis.annotations.Param;

public interface LikeCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LikeComment record);

    int insertSelective(LikeComment record);

    LikeComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LikeComment record);

    int updateByPrimaryKey(LikeComment record);

    LikeComment selectIsMeLikeComment(
            @Param("user_id") Long userId,
            @Param("comment_id") Long commentId
    );

    int deleteALikeComment(
            @Param("user_id") Long userId,
            @Param("comment_id") Long commentId
    );

    int deleteLikeCommentByMusicCommentId(
            @Param("comment_id") Long commentId
    );
}