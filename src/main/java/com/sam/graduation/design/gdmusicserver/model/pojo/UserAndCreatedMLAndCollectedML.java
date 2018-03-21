package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/21 09:44:31
 */
public class UserAndCreatedMLAndCollectedML {

    private Long userId;

    private String userNickname;

    private String userIntroduction;

    private Byte userSex;

    private Date userDateOfBirth;

    private String userProvince;

    private String userCity;

    private String userHeadPhoto;

    private Integer numOfUserCreatedMusicList;

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
}
