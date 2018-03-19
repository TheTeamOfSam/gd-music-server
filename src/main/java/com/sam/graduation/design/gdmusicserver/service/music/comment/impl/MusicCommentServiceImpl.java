package com.sam.graduation.design.gdmusicserver.service.music.comment.impl;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicCommentDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicCommentAndLCDto;
import com.sam.graduation.design.gdmusicserver.controller.pub.AppException;
import com.sam.graduation.design.gdmusicserver.dao.LikeCommentMapper;
import com.sam.graduation.design.gdmusicserver.dao.MusicCommentMapper;
import com.sam.graduation.design.gdmusicserver.dao.UserMusicCommentAndLCMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.LikeComment;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicComment;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicCommentAndLC;
import com.sam.graduation.design.gdmusicserver.service.base.BaseService;
import com.sam.graduation.design.gdmusicserver.service.music.comment.MusicCommentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 16:52:12
 */
@Service
public class MusicCommentServiceImpl extends BaseService implements MusicCommentService {

    @Value("${url.link}")
    private String urlLink;

    private static final String defaultHeadImagePath = "/head/image/default_head_photo.png";

    private static final String FILE_SEPARATOR = File.separator;

    @Autowired
    private MusicCommentMapper musicCommentMapper;

    @Autowired
    private LikeCommentMapper likeCommentMapper;

    @Autowired
    private UserMusicCommentAndLCMapper userMusicCommentAndLCMapper;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto commentMusic(MusicCommentDto musicCommentDto) {
        MessageDto messageDto = null;

        MusicComment musicComment = musicCommentDto.to();
        int commentResult;
        try {
            commentResult = this.musicCommentMapper.insertSelective(musicComment);
        } catch (Exception e) {
            logger.error("e:{}", e);
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

    @Override
    public List<UserMusicCommentAndLCDto> findUserMusicCommentAndLC(Long userId, Long musicId) {
        List<UserMusicCommentAndLCDto> userMusicCommentAndLCDtos = null;

        if (userId == null) {
            // 未登录下去查找音乐评论
            List<UserMusicCommentAndLC> userMusicCommentAndLCS = null;
            try {
                userMusicCommentAndLCS = this.userMusicCommentAndLCMapper.selectMusicCommentByMusicId(musicId);
            } catch (Exception e) {
                logger.error("e:{}", e);
            }
            if (userMusicCommentAndLCS == null) {
                userMusicCommentAndLCDtos = new ArrayList<UserMusicCommentAndLCDto>();
                return userMusicCommentAndLCDtos;
            } else {
                userMusicCommentAndLCDtos = new ArrayList<UserMusicCommentAndLCDto>();
                for (UserMusicCommentAndLC userMusicCommentAndLC : userMusicCommentAndLCS) {
                    UserMusicCommentAndLCDto userMusicCommentAndLCDto = new UserMusicCommentAndLCDto();
                    userMusicCommentAndLCDto.from(userMusicCommentAndLC);
                    if (StringUtils.isBlank(userMusicCommentAndLC.getUserHeadPhoto())) {
                        userMusicCommentAndLCDto.setUserHeadPhoto(urlLink + FILE_SEPARATOR + defaultHeadImagePath);
                    } else {
                        userMusicCommentAndLCDto.setUserHeadPhoto(urlLink + FILE_SEPARATOR + userMusicCommentAndLC.getUserHeadPhoto());
                    }
                    userMusicCommentAndLCDto.setMyComment(false);
                    userMusicCommentAndLCDto.setMeLikeComment(false);
                    userMusicCommentAndLCDtos.add(userMusicCommentAndLCDto);
                }
                return userMusicCommentAndLCDtos;
            }
        } else {
            // 登录下去查找音乐评论
            List<UserMusicCommentAndLC> userMusicCommentAndLCS = null;
            try {
                userMusicCommentAndLCS = this.userMusicCommentAndLCMapper.selectMusicCommentByMusicId(musicId);
            } catch (Exception e) {
                logger.error("e:{}", e);
            }
            if (userMusicCommentAndLCS == null) {
                userMusicCommentAndLCDtos = new ArrayList<UserMusicCommentAndLCDto>();
                return userMusicCommentAndLCDtos;
            } else {
                userMusicCommentAndLCDtos = new ArrayList<UserMusicCommentAndLCDto>();
                for (UserMusicCommentAndLC userMusicCommentAndLC : userMusicCommentAndLCS) {
                    UserMusicCommentAndLCDto userMusicCommentAndLCDto = new UserMusicCommentAndLCDto();
                    userMusicCommentAndLCDto.from(userMusicCommentAndLC);
                    if (StringUtils.isBlank(userMusicCommentAndLC.getUserHeadPhoto())) {
                        userMusicCommentAndLCDto.setUserHeadPhoto(urlLink + FILE_SEPARATOR + defaultHeadImagePath);
                    } else {
                        userMusicCommentAndLCDto.setUserHeadPhoto(urlLink + FILE_SEPARATOR + userMusicCommentAndLC.getUserHeadPhoto());
                    }
                    // 是否是我评论的
                    if (userId.equals(userMusicCommentAndLC.getUserId())) {
                        userMusicCommentAndLCDto.setMyComment(true);
                    } else {
                        userMusicCommentAndLCDto.setMyComment(false);
                    }
                    // 是否是我点赞的
                    LikeComment likeComment = null;
                    try {
                        likeComment = this.likeCommentMapper.selectIsMeLikeComment(userId, userMusicCommentAndLC.getMusicCommentId());
                    } catch (Exception e) {
                        logger.error("e:{}", e);
                    }
                    if (likeComment == null) {
                        userMusicCommentAndLCDto.setMeLikeComment(false);
                    } else {
                        userMusicCommentAndLCDto.setMeLikeComment(true);
                    }
                    userMusicCommentAndLCDtos.add(userMusicCommentAndLCDto);
                }
                return userMusicCommentAndLCDtos;
            }
        }
    }

    public static void main(String[] args) {
        Long a = 100000L;
        Long b = 100000L;
        System.out.println(a.equals(b));
    }

}
