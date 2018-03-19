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
import java.util.Date;
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

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto likeMusicComment(Long musicCommentId, Long userId) {
        MessageDto messageDto = null;

        LikeComment likeComment = new LikeComment();
        likeComment.setUserId(userId);
        likeComment.setCommentId(musicCommentId);
        likeComment.setLikeTime(new Date());
        likeComment.setCreatedTime(new Date());
        likeComment.setLastModifiedTime(new Date());
        likeComment.setIsDelete((byte) 0);

        int likeCommentResult = 0;

        try {
            likeCommentResult = this.likeCommentMapper.insertSelective(likeComment);
        } catch (Exception e) {
            logger.error("e:{}", e);
            throw new AppException("点赞评论异常");
        }
        if (likeCommentResult == 0) {
            messageDto = new MessageDto();
            messageDto.setMessage("点赞评论错误");
            messageDto.setSuccess(false);
            return messageDto;
        }
        messageDto = new MessageDto();
        messageDto.setMessage("点赞该评论成功");
        messageDto.setSuccess(true);
        return messageDto;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto unLikeMusicComment(Long musicCommentId, Long userId) {
        MessageDto messageDto = null;

        int unLikeCommentResult = 0;

        try {
            unLikeCommentResult = this.likeCommentMapper.deleteALikeComment(userId, musicCommentId);
        } catch (Exception e) {
            logger.error("e:{}", e);
            throw new AppException("取消点赞异常");
        }
        if (unLikeCommentResult == 0) {
            messageDto = new MessageDto();
            messageDto.setMessage("取消点赞错误");
            messageDto.setSuccess(false);
            return messageDto;
        }
        messageDto = new MessageDto();
        messageDto.setMessage("取消点赞该评论成功");
        messageDto.setSuccess(true);
        return messageDto;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public MessageDto deleteMusicComment(Long musicCommentId) {
        MessageDto messageDto = null;

        int deleteMusicCommentResult = 0;
        int deleteLikeMusicCommentResult = 0;

        try {
            deleteMusicCommentResult = this.musicCommentMapper.deleteByPrimaryKey(musicCommentId);
            deleteLikeMusicCommentResult = this.likeCommentMapper.deleteLikeCommentByMusicCommentId(musicCommentId);
        } catch (Exception e) {
            logger.error("e:{}",e);
            throw new AppException("删除评论或点赞评论异常");
        }
        if (deleteLikeMusicCommentResult == 0) {

        } else {

        }
        if (deleteMusicCommentResult == 0) {
            messageDto = new MessageDto();
            messageDto.setMessage("删除音乐评论错误");
            messageDto.setSuccess(false);
            return messageDto;
        }
        messageDto = new MessageDto();
        messageDto.setMessage("删除音乐评论成功");
        messageDto.setSuccess(true);
        return messageDto;
    }
}
