package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicCommentAndLC;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/19 17:29:57
 */
public interface UserMusicCommentAndLCMapper {

    List<UserMusicCommentAndLC> selectMusicCommentByMusicId(
            @Param("music_id") Long musicId
    );

}
