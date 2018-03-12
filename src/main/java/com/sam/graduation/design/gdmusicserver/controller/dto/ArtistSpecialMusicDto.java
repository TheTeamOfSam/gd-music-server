package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialMusic;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 09:08:49
 */
public class ArtistSpecialMusicDto {

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

    @JsonProperty("music_id")
    private Long musicId;

    @JsonProperty("music_name")
    private String musicName;

    @JsonProperty("music_duration")
    private Integer musicDuration;

    @JsonProperty("music_path")
    private String musicPath;

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

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public Integer getMusicDuration() {
        return musicDuration;
    }

    public void setMusicDuration(Integer musicDuration) {
        this.musicDuration = musicDuration;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }

    public ArtistSpecialMusic to() {
        ArtistSpecialMusic artistSpecialMusic = new ArtistSpecialMusic();
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
        artistSpecialMusic.setMusicId(this.musicId);
        artistSpecialMusic.setMusicName(this.musicName);
        artistSpecialMusic.setMusicDuration(this.musicDuration);
        artistSpecialMusic.setMusicPath(this.musicPath);
        return artistSpecialMusic;
    }

    public void from(ArtistSpecialMusic artistSpecialMusic) {
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
        this.musicId = artistSpecialMusic.getMusicId();
        this.musicName = artistSpecialMusic.getMusicName();
        this.musicDuration = artistSpecialMusic.getMusicDuration();
        this.musicPath = artistSpecialMusic.getMusicPath();
    }

}
