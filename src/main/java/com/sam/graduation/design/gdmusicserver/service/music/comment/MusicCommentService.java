package com.sam.graduation.design.gdmusicserver.service.music.comment;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicCommentDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicCommentAndLCDto;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 16:51:52
 */
public interface MusicCommentService {

    MessageDto commentMusic(MusicCommentDto musicCommentDto);

    List<UserMusicCommentAndLCDto> findUserMusicCommentAndLC(
            Long userId,
            Long musicId
    );

    MessageDto likeMusicComment(
            Long musicCommentId,
            Long userId
    );

    MessageDto unLikeMusicComment(
            Long musicCommentId,
            Long userId
    );

    MessageDto deleteMusicComment(
            Long musicCommentId
    );

}
