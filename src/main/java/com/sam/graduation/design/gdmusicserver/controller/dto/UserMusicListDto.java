package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicList;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/13 18:41:33
 */
public class UserMusicListDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("music_list_name")
    private String musicListName;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("intro")
    private String intro;

    @JsonProperty("generate_time")
    private Date generateTime;

    @JsonProperty("music_list_photo")
    private String musicListPhoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicListName() {
        return musicListName;
    }

    public void setMusicListName(String musicListName) {
        this.musicListName = musicListName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public String getMusicListPhoto() {
        return musicListPhoto;
    }

    public void setMusicListPhoto(String musicListPhoto) {
        this.musicListPhoto = musicListPhoto;
    }

    public UserMusicList to() {
        UserMusicList userMusicList = new UserMusicList();
        userMusicList.setMusicListName(this.musicListName);
        userMusicList.setUserId(this.userId);
        userMusicList.setIntro(this.intro);
        userMusicList.setGenerateTime(this.generateTime);
        userMusicList.setMusicListPhoto(this.musicListPhoto);
        return userMusicList;
    }

    public void from(UserMusicList userMusicList) {
        this.id = userMusicList.getId();
        this.musicListName = userMusicList.getMusicListName();
        this.userId = userMusicList.getUserId();
        this.intro = userMusicList.getIntro();
        this.generateTime = userMusicList.getGenerateTime();
        this.musicListPhoto = userMusicList.getMusicListPhoto();
    }
}
