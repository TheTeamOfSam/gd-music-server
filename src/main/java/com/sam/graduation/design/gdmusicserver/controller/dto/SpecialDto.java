package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.Special;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 14:44:38
 */
public class SpecialDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("special_name")
    private String specialName;

    @JsonProperty("artist_id")
    private Long artistId;

    @JsonProperty("publish_company")
    private String publishCompany;

    @JsonProperty("publish_time")
    private Date publishTime;

    @JsonProperty("special_photo")
    private String specialPhoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
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

    public String getSpecialPhoto() {
        return specialPhoto;
    }

    public void setSpecialPhoto(String specialPhoto) {
        this.specialPhoto = specialPhoto;
    }

    public Special to() {
        Special special = new Special();
        special.setSpecialName(this.specialName);
        special.setArtistId(this.artistId);
        special.setPublishCompany(this.publishCompany);
        special.setPublishTime(this.publishTime);
        special.setSpecialPhoto(this.specialPhoto);
        special.setCreatedTime(new Date());
        special.setLastModifiedTime(new Date());
        special.setIsDelete((byte) 0);
        return special;
    }

    public void from(Special special) {
        this.artistId = special.getArtistId();
        this.id = special.getId();
        this.specialName = special.getSpecialName();
        this.specialPhoto = special.getSpecialPhoto();
        this.publishCompany = special.getPublishCompany();
        this.publishTime = special.getPublishTime();
    }
}
