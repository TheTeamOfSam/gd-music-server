package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserUserMusicListAndMusicInIt;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/15 10:44:11
 */
public class UserUserMusicListAndMusicInItDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_nickname")
    private String userNickname;

    @JsonProperty("user_head_photo")
    private String userHeadPhoto;

    @JsonProperty("user_music_list_id")
    private Long userMusicListId;

    @JsonProperty("user_music_list_name")
    private String userMusicListName;

    @JsonProperty("user_music_list_photo")
    private String userMusicListPhoto;

    @JsonProperty("user_music_list_intro")
    private String userMusicListIntro;

    @JsonProperty("user_music_list_created_time")
    private Date userMusicListCreatedTime;

    @JsonProperty("num_of_music_in_user_music_list")
    private Integer numOfMusicInUserMusicList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserHeadPhoto() {
        return userHeadPhoto;
    }

    public void setUserHeadPhoto(String userHeadPhoto) {
        this.userHeadPhoto = userHeadPhoto;
    }

    public Long getUserMusicListId() {
        return userMusicListId;
    }

    public void setUserMusicListId(Long userMusicListId) {
        this.userMusicListId = userMusicListId;
    }

    public String getUserMusicListIntro() {
        return userMusicListIntro;
    }

    public void setUserMusicListIntro(String userMusicListIntro) {
        this.userMusicListIntro = userMusicListIntro;
    }

    public String getUserMusicListName() {
        return userMusicListName;
    }

    public void setUserMusicListName(String userMusicListName) {
        this.userMusicListName = userMusicListName;
    }

    public String getUserMusicListPhoto() {
        return userMusicListPhoto;
    }

    public void setUserMusicListPhoto(String userMusicListPhoto) {
        this.userMusicListPhoto = userMusicListPhoto;
    }

    public Date getUserMusicListCreatedTime() {
        return userMusicListCreatedTime;
    }

    public void setUserMusicListCreatedTime(Date userMusicListCreatedTime) {
        this.userMusicListCreatedTime = userMusicListCreatedTime;
    }

    public Integer getNumOfMusicInUserMusicList() {
        return numOfMusicInUserMusicList;
    }

    public void setNumOfMusicInUserMusicList(Integer numOfMusicInUserMusicList) {
        this.numOfMusicInUserMusicList = numOfMusicInUserMusicList;
    }

    public UserUserMusicListAndMusicInIt to() {
        UserUserMusicListAndMusicInIt userUserMusicListAndMusicInIt = new UserUserMusicListAndMusicInIt();
        userUserMusicListAndMusicInIt.setUserId(this.userId);
        userUserMusicListAndMusicInIt.setUserNickname(this.userNickname);
        userUserMusicListAndMusicInIt.setUserHeadPhoto(this.userHeadPhoto);
        userUserMusicListAndMusicInIt.setUserMusicListId(this.userMusicListId);
        userUserMusicListAndMusicInIt.setUserMusicListName(this.userMusicListName);
        userUserMusicListAndMusicInIt.setUserMusicListPhoto(this.userMusicListPhoto);
        userUserMusicListAndMusicInIt.setUserMusicListIntro(this.userMusicListIntro);
        userUserMusicListAndMusicInIt.setUserMusicListCreatedTime(this.userMusicListCreatedTime);
        userUserMusicListAndMusicInIt.setNumOfMusicInUserMusicList(this.numOfMusicInUserMusicList);
        return userUserMusicListAndMusicInIt;
    }

    public void from(UserUserMusicListAndMusicInIt userUserMusicListAndMusicInIt) {
        this.userId = userUserMusicListAndMusicInIt.getUserId();
        this.userNickname = userUserMusicListAndMusicInIt.getUserNickname();
        this.userHeadPhoto = userUserMusicListAndMusicInIt.getUserHeadPhoto();
        this.userMusicListId = userUserMusicListAndMusicInIt.getUserMusicListId();
        this.userMusicListName = userUserMusicListAndMusicInIt.getUserMusicListName();
        this.userMusicListIntro = userUserMusicListAndMusicInIt.getUserMusicListIntro();
        this.userMusicListPhoto = userUserMusicListAndMusicInIt.getUserMusicListPhoto();
        this.userMusicListCreatedTime = userUserMusicListAndMusicInIt.getUserMusicListCreatedTime();
        this.numOfMusicInUserMusicList = userUserMusicListAndMusicInIt.getNumOfMusicInUserMusicList();
    }
}
