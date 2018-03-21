package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserAndCreatedMLAndCollectedML;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/21 09:59:22
 */
public class UserAndCreatedMLAndCollectedMLDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_nickname")
    private String userNickname;

    @JsonProperty("user_introduction")
    private String userIntroduction;

    @JsonProperty("user_sex")
    private Byte userSex;

    @JsonProperty("user_date_of_birth")
    private Date userDateOfBirth;

    @JsonProperty("user_province")
    private String userProvince;

    @JsonProperty("user_city")
    private String userCity;

    @JsonProperty("user_head_photo")
    private String userHeadPhoto;

    @JsonProperty("num_of_user_created_music_list")
    private Integer numOfUserCreatedMusicList;

    @JsonProperty("num_of_user_collected_music_list")
    private Integer numOfUserCollectedMusicList;

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

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserHeadPhoto() {
        return userHeadPhoto;
    }

    public void setUserHeadPhoto(String userHeadPhoto) {
        this.userHeadPhoto = userHeadPhoto;
    }

    public Integer getNumOfUserCreatedMusicList() {
        return numOfUserCreatedMusicList;
    }

    public void setNumOfUserCreatedMusicList(Integer numOfUserCreatedMusicList) {
        this.numOfUserCreatedMusicList = numOfUserCreatedMusicList;
    }

    public Integer getNumOfUserCollectedMusicList() {
        return numOfUserCollectedMusicList;
    }

    public void setNumOfUserCollectedMusicList(Integer numOfUserCollectedMusicList) {
        this.numOfUserCollectedMusicList = numOfUserCollectedMusicList;
    }

    public UserAndCreatedMLAndCollectedML to() {
        UserAndCreatedMLAndCollectedML userAndCreatedMLAndCollectedML = new UserAndCreatedMLAndCollectedML();
        userAndCreatedMLAndCollectedML.setUserId(this.userId);
        userAndCreatedMLAndCollectedML.setUserNickname(this.userNickname);
        userAndCreatedMLAndCollectedML.setUserIntroduction(this.userIntroduction);
        userAndCreatedMLAndCollectedML.setUserSex(this.userSex);
        userAndCreatedMLAndCollectedML.setUserDateOfBirth(this.userDateOfBirth);
        userAndCreatedMLAndCollectedML.setUserProvince(this.userProvince);
        userAndCreatedMLAndCollectedML.setUserCity(this.userCity);
        userAndCreatedMLAndCollectedML.setUserHeadPhoto(this.userHeadPhoto);
        userAndCreatedMLAndCollectedML.setNumOfUserCreatedMusicList(this.numOfUserCreatedMusicList);
        userAndCreatedMLAndCollectedML.setNumOfUserCollectedMusicList(this.numOfUserCollectedMusicList);
        return userAndCreatedMLAndCollectedML;
    }

    public void from(UserAndCreatedMLAndCollectedML userAndCreatedMLAndCollectedML) {
        this.userId = userAndCreatedMLAndCollectedML.getUserId();
        this.userNickname = userAndCreatedMLAndCollectedML.getUserNickname();
        this.userIntroduction = userAndCreatedMLAndCollectedML.getUserIntroduction();
        this.userSex = userAndCreatedMLAndCollectedML.getUserSex();
        this.userDateOfBirth = userAndCreatedMLAndCollectedML.getUserDateOfBirth();
        this.userProvince= userAndCreatedMLAndCollectedML.getUserProvince();
        this.userCity = userAndCreatedMLAndCollectedML.getUserCity();
        this.userHeadPhoto = userAndCreatedMLAndCollectedML.getUserHeadPhoto();
        this.numOfUserCreatedMusicList = userAndCreatedMLAndCollectedML.getNumOfUserCreatedMusicList();
        this.numOfUserCollectedMusicList = userAndCreatedMLAndCollectedML.getNumOfUserCollectedMusicList();
    }

}
