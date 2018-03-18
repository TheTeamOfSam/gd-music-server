package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialAndNumOfMusicInSpecial;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 14:27:53
 */
public class ArtistSpecialAndNumOfMusicInSpecialDto {

    @JsonProperty("artist_id")
    private Long artistId;

    @JsonProperty("artist_name")
    private String artistName;

    @JsonProperty("special_photo")
    private String specialPhoto;

    @JsonProperty("special_name")
    private String specialName;

    @JsonProperty("publish_company")
    private String publishCompany;

    @JsonProperty("publish_time")
    private Date publishTime;

    @JsonProperty("num_of_music_in_special")
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

    public ArtistSpecialAndNumOfMusicInSpecial to() {
        ArtistSpecialAndNumOfMusicInSpecial artistSpecialAndNumOfMusicInSpecial = new ArtistSpecialAndNumOfMusicInSpecial();
        artistSpecialAndNumOfMusicInSpecial.setArtistId(this.artistId);
        artistSpecialAndNumOfMusicInSpecial.setArtistName(this.artistName);
        artistSpecialAndNumOfMusicInSpecial.setNumOfMusicInSpecial(this.numOfMusicInSpecial);
        artistSpecialAndNumOfMusicInSpecial.setPublishCompany(this.publishCompany);
        artistSpecialAndNumOfMusicInSpecial.setPublishTime(this.publishTime);
        artistSpecialAndNumOfMusicInSpecial.setSpecialName(this.specialName);
        artistSpecialAndNumOfMusicInSpecial.setSpecialPhoto(this.specialPhoto);
        return artistSpecialAndNumOfMusicInSpecial;
    }

    public void from(ArtistSpecialAndNumOfMusicInSpecial artistSpecialAndNumOfMusicInSpecial) {
        this.artistId = artistSpecialAndNumOfMusicInSpecial.getArtistId();
        this.artistName = artistSpecialAndNumOfMusicInSpecial.getArtistName();
        this.numOfMusicInSpecial = artistSpecialAndNumOfMusicInSpecial.getNumOfMusicInSpecial();
        this.publishCompany = artistSpecialAndNumOfMusicInSpecial.getPublishCompany();
        this.publishTime = artistSpecialAndNumOfMusicInSpecial.getPublishTime();
        this.specialName = artistSpecialAndNumOfMusicInSpecial.getSpecialName();
        this.specialPhoto = artistSpecialAndNumOfMusicInSpecial.getSpecialPhoto();
    }
}
