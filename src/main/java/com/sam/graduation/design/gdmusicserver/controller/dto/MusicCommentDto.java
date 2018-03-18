package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicComment;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 16:45:09
 */
public class MusicCommentDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("music_id")
    private Long musicId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("comment_content")
    private String commentContent;

    @JsonProperty("comment_time")
    private Date commentTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public MusicComment to() {
        MusicComment musicComment = new MusicComment();
        musicComment.setId(this.id);
        musicComment.setMusicId(this.musicId);
        musicComment.setUserId(this.userId);
        musicComment.setCommentContent(this.commentContent);
        musicComment.setCommentTime(new Date());
        musicComment.setCreatedTime(new Date());
        musicComment.setLastModifiedTime(new Date());
        musicComment.setIsDelete((byte) 0);
        return musicComment;
    }

    public void from(MusicComment musicComment) {
        this.id = musicComment.getId();
        this.musicId = musicComment.getMusicId();
        this.userId = musicComment.getUserId();
        this.commentContent = musicComment.getCommentContent();
        this.commentTime = musicComment.getCommentTime();
    }

}
