package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

public class UserMusicList {
    private Long id;

    private String musicListName;

    private Long userId;

    private String intro;

    private Date generateTime;

    private String musicListPhoto;

    private Date createdTime;

    private Date lastModifiedTime;

    private Byte isDelete;

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
        this.musicListName = musicListName == null ? null : musicListName.trim();
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
        this.intro = intro == null ? null : intro.trim();
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
        this.musicListPhoto = musicListPhoto == null ? null : musicListPhoto.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}