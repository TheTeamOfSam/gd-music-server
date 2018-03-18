package com.sam.graduation.design.gdmusicserver.model.pojo;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 14:17:05
 */
public class ArtistSpecialAndNumOfMusicInSpecial {

    private Long artistId;

    private String artistName;

    private String specialPhoto;

    private String specialName;

    private String publishCompany;

    private Date publishTime;

    private Integer numOfMusicInSpecial;

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

    public String getSpecialPhoto() {
        return specialPhoto;
    }

    public void setSpecialPhoto(String specialPhoto) {
        this.specialPhoto = specialPhoto;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public String getPublishCompany() {
        return publishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getNumOfMusicInSpecial() {
        return numOfMusicInSpecial;
    }

    public void setNumOfMusicInSpecial(Integer numOfMusicInSpecial) {
        this.numOfMusicInSpecial = numOfMusicInSpecial;
    }
}
