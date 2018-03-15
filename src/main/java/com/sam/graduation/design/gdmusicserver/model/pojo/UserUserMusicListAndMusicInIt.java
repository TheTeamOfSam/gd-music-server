package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/15 10:32:48
 */
public class UserUserMusicListAndMusicInIt {

    private Long userId;

    private String userNickname;

    private String userHeadPhoto;

    private Long userMusicListId;

    private String userMusicListName;

    private String userMusicListPhoto;

    private String userMusicListIntro;

    private Date userMusicListCreatedTime;

    private Integer numOfMusicInUserMusicList;

    public String getUserMusicListIntro() {
        return userMusicListIntro;
    }

    public void setUserMusicListIntro(String userMusicListIntro) {
        this.userMusicListIntro = userMusicListIntro;
    }

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
}
