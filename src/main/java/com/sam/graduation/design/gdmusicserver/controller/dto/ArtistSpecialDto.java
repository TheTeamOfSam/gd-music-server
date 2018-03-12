package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecial;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 15:16:31
 */
public class ArtistSpecialDto {

    @JsonProperty("artist_id")
    private Long artistId;

    @JsonProperty("artist_name")
    private String artistName;

    @JsonProperty("artist_other_name")
    private String artistOtherName;

    @JsonProperty("artist_intro")
    private String artistIntro;

    @JsonProperty("artist_head_photo_big")
    private String artistHeadPhotoBig;

    @JsonProperty("artist_head_photo_small")
    private String artistHeadPhotoSmall;

    @JsonProperty("special_id")
    private Long specialId;

    @JsonProperty("special_name")
    private String specialName;

    @JsonProperty("special_publish_company")
    private String specialPublishCompany;

    @JsonProperty("special_photo")
    private String specialPhoto;

    @JsonProperty("special_publish_time")
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

    public ArtistSpecial to() {
        ArtistSpecial artistSpecialMusic = new ArtistSpecial();
        artistSpecialMusic.setArtistId(this.artistId);
        artistSpecialMusic.setArtistName(this.artistName);
        artistSpecialMusic.setArtistOtherName(this.artistOtherName);
        artistSpecialMusic.setArtistIntro(this.artistIntro);
        artistSpecialMusic.setArtistHeadPhotoBig(this.artistHeadPhotoBig);
        artistSpecialMusic.setArtistHeadPhotoSmall(this.artistHeadPhotoSmall);
        artistSpecialMusic.setSpecialId(this.specialId);
        artistSpecialMusic.setSpecialName(this.specialName);
        artistSpecialMusic.setSpecialPhoto(this.specialPhoto);
        artistSpecialMusic.setSpecialPublishCompany(this.specialPublishCompany);
        artistSpecialMusic.setSpecialPublishTime(this.specialPublishTime);
        return artistSpecialMusic;
    }

    public void from(ArtistSpecial artistSpecialMusic) {
        this.artistId = artistSpecialMusic.getArtistId();
        this.artistName = artistSpecialMusic.getArtistName();
        this.artistOtherName = artistSpecialMusic.getArtistOtherName();
        this.artistIntro = artistSpecialMusic.getArtistIntro();
        this.artistHeadPhotoBig = artistSpecialMusic.getArtistHeadPhotoBig();
        this.artistHeadPhotoSmall = artistSpecialMusic.getArtistHeadPhotoSmall();
        this.specialId = artistSpecialMusic.getSpecialId();
        this.specialName = artistSpecialMusic.getSpecialName();
        this.specialPhoto = artistSpecialMusic.getSpecialPhoto();
        this.specialPublishCompany = artistSpecialMusic.getSpecialPublishCompany();
        this.specialPublishTime = artistSpecialMusic.getSpecialPublishTime();
    }
}
