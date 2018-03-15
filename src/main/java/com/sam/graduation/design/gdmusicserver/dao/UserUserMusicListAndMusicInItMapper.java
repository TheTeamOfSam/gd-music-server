package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.UserUserMusicListAndMusicInIt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/15 10:33:26
 */
public interface UserUserMusicListAndMusicInItMapper {

    List<UserUserMusicListAndMusicInIt> selectLikeUserMusicListName(
            @Param("user_music_list_name") String userMusicListName
    );

}
