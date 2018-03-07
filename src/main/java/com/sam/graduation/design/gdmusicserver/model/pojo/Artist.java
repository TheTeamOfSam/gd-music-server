package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

public class Artist {
    private Long id;

    private String artistName;

    private String artistOtherName;

    private String intro;

    private String artistHeadPhotoBig;

    private String artistHeadPhotoSmall;

    private Date createdTime;

    private Date lastModifiedTime;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName == null ? null : artistName.trim();
    }

    public String getArtistOtherName() {
        return artistOtherName;
    }

    public void setArtistOtherName(String artistOtherName) {
        this.artistOtherName = artistOtherName == null ? null : artistOtherName.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getArtistHeadPhotoBig() {
        return artistHeadPhotoBig;
    }

    public void setArtistHeadPhotoBig(String artistHeadPhotoBig) {
        this.artistHeadPhotoBig = artistHeadPhotoBig == null ? null : artistHeadPhotoBig.trim();
    }

    public String getArtistHeadPhotoSmall() {
        return artistHeadPhotoSmall;
    }

    public void setArtistHeadPhotoSmall(String artistHeadPhotoSmall) {
        this.artistHeadPhotoSmall = artistHeadPhotoSmall == null ? null : artistHeadPhotoSmall.trim();
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