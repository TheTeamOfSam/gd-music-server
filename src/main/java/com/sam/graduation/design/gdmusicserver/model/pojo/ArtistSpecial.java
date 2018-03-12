package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 15:08:24
 */
public class ArtistSpecial {

    private Long artistId;

    private String artistName;

    private String artistOtherName;

    private String artistIntro;

    private String artistHeadPhotoBig;

    private String artistHeadPhotoSmall;

    private Long specialId;

    private String specialName;

    private String specialPublishCompany;

    private String specialPhoto;

    private Date specialPublishTime;

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistOtherName() {
        return artistOtherName;
    }

    public void setArtistOtherName(String artistOtherName) {
        this.artistOtherName = artistOtherName;
    }

    public String getArtistIntro() {
        return artistIntro;
    }

    public void setArtistIntro(String artistIntro) {
        this.artistIntro = artistIntro;
    }

    public String getArtistHeadPhotoBig() {
        return artistHeadPhotoBig;
    }

    public void setArtistHeadPhotoBig(String artistHeadPhotoBig) {
        this.artistHeadPhotoBig = artistHeadPhotoBig;
    }

    public String getArtistHeadPhotoSmall() {
        return artistHeadPhotoSmall;
    }

    public void setArtistHeadPhotoSmall(String artistHeadPhotoSmall) {
        this.artistHeadPhotoSmall = artistHeadPhotoSmall;
    }

    public Long getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getSpecialPublishCompany() {
        return specialPublishCompany;
    }

    public void setSpecialPublishCompany(String specialPublishCompany) {
        this.specialPublishCompany = specialPublishCompany;
    }

    public String getSpecialPhoto() {
        return specialPhoto;
    }

    public void setSpecialPhoto(String specialPhoto) {
        this.specialPhoto = specialPhoto;
    }

    public Date getSpecialPublishTime() {
        return specialPublishTime;
    }

    public void setSpecialPublishTime(Date specialPublishTime) {
        this.specialPublishTime = specialPublishTime;
    }
}
