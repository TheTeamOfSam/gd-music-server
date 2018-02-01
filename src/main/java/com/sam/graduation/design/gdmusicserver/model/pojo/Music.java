package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

public class Music {
    private Long id;

    private String musicName;

    private Long specialId;

    private String musicPath;

    private Integer musicDuration;

    private Date createdTime;

    private Date lastModifiedTime;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName == null ? null : musicName.trim();
    }

    public Long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath == null ? null : musicPath.trim();
    }

    public Integer getMusicDuration() {
        return musicDuration;
    }

    public void setMusicDuration(Integer musicDuration) {
        this.musicDuration = musicDuration;
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