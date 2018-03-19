package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicCommentAndLC;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/19 17:38:29
 */
public class UserMusicCommentAndLCDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_head_photo")
    private String userHeadPhoto;

    @JsonProperty("user_nickname")
    private String userNickname;

    @JsonProperty("music_comment_id")
    private Long musicCommentId;

    @JsonProperty("music_comment_content")
    private String musicCommentContent;

    @JsonProperty("music_comment_time")
    private Date musicCommentTime;

    @JsonProperty("num_of_like_comment_of_music")
    private Integer numOfLikeCommentOfMusic;

    @JsonProperty("is_my_comment")
    private boolean isMyComment;

    @JsonProperty("is_me_like_comment")
    private boolean isMeLikeComment;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserHeadPhoto() {
        return userHeadPhoto;
    }

    public void setUserHeadPhoto(String userHeadPhoto) {
        this.userHeadPhoto = userHeadPhoto;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Long getMusicCommentId() {
        return musicCommentId;
    }

    public void setMusicCommentId(Long musicCommentId) {
        this.musicCommentId = musicCommentId;
    }

    public String getMusicCommentContent() {
        return musicCommentContent;
    }

    public void setMusicCommentContent(String musicCommentContent) {
        this.musicCommentContent = musicCommentContent;
    }

    public Date getMusicCommentTime() {
        return musicCommentTime;
    }

    public void setMusicCommentTime(Date musicCommentTime) {
        this.musicCommentTime = musicCommentTime;
    }

    public Integer getNumOfLikeCommentOfMusic() {
        return numOfLikeCommentOfMusic;
    }

    public void setNumOfLikeCommentOfMusic(Integer numOfLikeCommentOfMusic) {
        this.numOfLikeCommentOfMusic = numOfLikeCommentOfMusic;
    }

    public boolean isMyComment() {
        return isMyComment;
    }

    public void setMyComment(boolean myComment) {
        isMyComment = myComment;
    }

    public boolean isMeLikeComment() {
        return isMeLikeComment;
    }

    public void setMeLikeComment(boolean meLikeComment) {
        isMeLikeComment = meLikeComment;
    }

    public UserMusicCommentAndLC to() {
        UserMusicCommentAndLC userMusicCommentAndLC = new UserMusicCommentAndLC();
        userMusicCommentAndLC.setUserId(this.userId);
        userMusicCommentAndLC.setUserHeadPhoto(this.userHeadPhoto);
        userMusicCommentAndLC.setUserNickname(this.userNickname);
        userMusicCommentAndLC.setMusicCommentId(this.musicCommentId);
        userMusicCommentAndLC.setMusicCommentContent(this.musicCommentContent);
        userMusicCommentAndLC.setMusicCommentTime(this.musicCommentTime);
        userMusicCommentAndLC.setNumOfLikeCommentOfMusic(this.numOfLikeCommentOfMusic);
        return userMusicCommentAndLC;
    }

    public void from(UserMusicCommentAndLC userMusicCommentAndLC) {
        this.userId = userMusicCommentAndLC.getUserId();
        this.userHeadPhoto = userMusicCommentAndLC.getUserHeadPhoto();
        this.userNickname = userMusicCommentAndLC.getUserNickname();
        this.musicCommentId = userMusicCommentAndLC.getMusicCommentId();
        this.musicCommentContent = userMusicCommentAndLC.getMusicCommentContent();
        this.musicCommentTime = userMusicCommentAndLC.getMusicCommentTime();
        this.numOfLikeCommentOfMusic = userMusicCommentAndLC.getNumOfLikeCommentOfMusic();
    }

}
