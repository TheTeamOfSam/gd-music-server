package com.sam.graduation.design.gdmusicserver.service.music.comment.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicCommentDto;
import com.sam.graduation.design.gdmusicserver.controller.pub.AppException;
import com.sam.graduation.design.gdmusicserver.dao.MusicCommentMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicComment;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.music.comment.MusicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 16:52:12
 */
@Service
public class MusicCommentServiceImpl extends BaseService implements MusicCommentService {

    @Autowired
    private MusicCommentMapper musicCommentMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto commentMusic(MusicCommentDto musicCommentDto) {
        MessageDto messageDto = null;

        MusicComment musicComment = musicCommentDto.to();
        int commentResult;
        try {
            commentResult = this.musicCommentMapper.insertSelective(musicComment);
        } catch (Exception e) {
            logger.error("e:{}",e);
            throw new AppException("评论异常");
        }
        if (commentResult == 0) {
            messageDto = new MessageDto();
            messageDto.setSuccess(false);
            messageDto.setMessage("评论错误");
            return messageDto;
        }
        messageDto = new MessageDto();
        messageDto.setSuccess(true);
        messageDto.setMessage("评论成功");
        return messageDto;
    }
}
