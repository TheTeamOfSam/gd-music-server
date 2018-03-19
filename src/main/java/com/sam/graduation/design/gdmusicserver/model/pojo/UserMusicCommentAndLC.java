package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/19 17:26:50
 */
public class UserMusicCommentAndLC {

    private Long userId;

    private String userHeadPhoto;

    private String userNickname;

    private Long musicCommentId;

    private String musicCommentContent;

    private Date musicCommentTime;

    private Integer numOfLikeCommentOfMusic;

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
}
