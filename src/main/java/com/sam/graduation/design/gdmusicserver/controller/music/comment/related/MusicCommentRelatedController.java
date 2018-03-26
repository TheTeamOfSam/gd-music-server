package com.sam.graduation.design.gdmusicserver.controller.music.comment.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicCommentDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicCommentAndLCDto;
import com.sam.graduation.design.gdmusicserver.service.music.comment.MusicCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 音乐评论相关接口
 *
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 16:59:49
 */
@RestController
@Api("音乐评论相关接口")
@RequestMapping("/gdmusicserver")
public class MusicCommentRelatedController extends BaseController {

    @Autowired
    private MusicCommentService musicCommentService;

    /**
     * 音乐评论接口
     *
     * @param userId         用户id
     * @param musicId        音乐id
     * @param commentContent 用户评论内容
     * @return map
     */
    @ApiOperation("音乐评论接口")
    @RequestMapping(value = "/comment/music/@comment", method = RequestMethod.POST)
    public Map<String, Object> commentMusic(
            @RequestParam(value = "user_id", required = false) Long userId,
            @RequestParam(value = "music_id", required = false) Long musicId,
            @RequestParam(value = "comment_content", required = false) String commentContent
    ) {
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (musicId == null) {
            return this.error("歌曲id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(commentContent)) {
            return this.error("评论内容不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        } else if (commentContent.length() > 150) {
            return this.error("评论内容超过字数限制", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        MessageDto messageDto = null;

        MusicCommentDto musicCommentDto = new MusicCommentDto();
        musicCommentDto.setUserId(userId);
        musicCommentDto.setMusicId(musicId);
        musicCommentDto.setCommentContent(commentContent);
        musicCommentDto.setCommentTime(new Date());

        try {
            messageDto = this.musicCommentService.commentMusic(musicCommentDto);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (messageDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        if (!messageDto.isSuccess()) {
            return this.error(messageDto.getMessage(), ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        return this.success(messageDto);
    }


    /**
     * 音乐评论显示相关接口
     *
     * @param userId  用户id
     * @param musicId 音乐id
     * @return map
     */
    @ApiOperation("音乐评论显示相关接口")
    @RequestMapping(value = "/get/music/comment/by/music/id/or/user/id/@query", method = RequestMethod.GET)
    public Map<String, Object> getMusicCommentByMusicIdOrUserId(
            @RequestParam(value = "user_id", required = false) Long userId,
            @RequestParam(value = "music_id", required = false) Long musicId
    ) {
        if (musicId == null) {
            return this.error("音乐id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<UserMusicCommentAndLCDto> userMusicCommentAndLCDtos = null;
        try {
            userMusicCommentAndLCDtos = this.musicCommentService.findUserMusicCommentAndLC(userId, musicId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userMusicCommentAndLCDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userMusicCommentAndLCDtos);
    }

    /**
     * 音乐评论点赞接口
     *
     * @param musicCommentId 音乐评论id
     * @param userId         用户id
     * @return map
     */
    @ApiOperation("音乐评论点赞接口")
    @RequestMapping(value = "/like/music/comment/@like", method = RequestMethod.POST)
    public Map<String, Object> likeMusicComment(
            @RequestParam(value = "music_comment_id", required = false) Long musicCommentId,
            @RequestParam(value = "user_id", required = false) Long userId
    ) {
        if (musicCommentId == null) {
            return this.error("评论id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        MessageDto messageDto = null;
        try {
            messageDto = this.musicCommentService.likeMusicComment(musicCommentId, userId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (messageDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        if (!messageDto.isSuccess()) {
            return this.error(messageDto.getMessage(), ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        return this.success(messageDto);
    }

    /**
     * 音乐评论取消点赞接口
     *
     * @param musicCommentId 音乐评论id
     * @param userId         用户id
     * @return map
     */
    @ApiOperation("音乐评论取消点赞接口")
    @RequestMapping(value = "/un/like/music/comment/@unlike", method = RequestMethod.POST)
    public Map<String, Object> unLikeMusicComment(
            @RequestParam(value = "music_comment_id", required = false) Long musicCommentId,
            @RequestParam(value = "user_id", required = false) Long userId
    ) {
        if (musicCommentId == null) {
            return this.error("评论id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        MessageDto messageDto = null;
        try {
            messageDto = this.musicCommentService.unLikeMusicComment(musicCommentId, userId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (messageDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        if (!messageDto.isSuccess()) {
            return this.error(messageDto.getMessage(), ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        return this.success(messageDto);
    }

    /**
     * 删除音乐评论接口
     *
     * @param musicCommentId 评论id
     * @return map
     */
    @ApiOperation("删除音乐评论接口")
    @RequestMapping(value = "/delete/music/comment/@delete", method = RequestMethod.POST)
    public Map<String, Object> deleteMusicComment(
            @RequestParam(value = "music_comment_id", required = false) Long musicCommentId
    ) {
        if (musicCommentId == null) {
            return this.error("音乐评论id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        MessageDto messageDto = null;
        try {
            messageDto = this.musicCommentService.deleteMusicComment(musicCommentId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (messageDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        if (!messageDto.isSuccess()) {
            return this.error(messageDto.getMessage(), ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        return this.success(messageDto);
    }

}
