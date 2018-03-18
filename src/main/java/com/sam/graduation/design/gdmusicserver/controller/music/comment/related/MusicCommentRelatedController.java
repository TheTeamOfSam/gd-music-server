package com.sam.graduation.design.gdmusicserver.controller.music.comment.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicCommentDto;
import com.sam.graduation.design.gdmusicserver.controller.pub.AppException;
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
import java.util.Map;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 16:59:49
 */
@RestController
@Api("音乐评论相关接口")
@RequestMapping("/gdmusicserver")
public class MusicCommentRelatedController extends BaseController {

    @Autowired
    private MusicCommentService musicCommentService;

    @ApiOperation("音乐评论接口")
    @RequestMapping(value = "/comment/music/@comment", method = RequestMethod.POST)
    public Map<String, Object> commentMusic(
            @RequestParam(value = "user_id", required = false) Long userId,
            @RequestParam(value = "music_id", required = false) Long musicId,
            @RequestParam(value = "comment_content", required = false) String commentContent
    ) {
        if (StringUtils.isBlank(String.valueOf(userId.longValue()))) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(String.valueOf(musicId.longValue()))) {
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

}
