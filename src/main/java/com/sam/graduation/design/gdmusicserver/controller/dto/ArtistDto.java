package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.Artist;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/12 13:36:14
 */
public class ArtistDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("artist_name")
    private String artistName;

    @JsonProperty("artist_other_name")
    private String artistOtherName;

    @JsonProperty("artist_intro")
    private String intro;

    @JsonProperty("artist_head_photo_big")
    private String artistHeadPhotoBig;

    @JsonProperty("artist_head_photo_small")
    private String artistHeadPhotoSmall;

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
        this.artistName = artistName;
    }

    public String getArtistOtherName() {
        return artistOtherName;
    }

    public void setArtistOtherName(String artistOtherName) {
        this.artistOtherName = artistOtherName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public Artist to() {
        Artist artist = new Artist();
        artist.setArtistName(this.artistName);
        artist.setArtistOtherName(this.artistOtherName);
        artist.setArtistHeadPhotoBig(this.artistHeadPhotoBig);
        artist.setArtistHeadPhotoSmall(this.artistHeadPhotoSmall);
        artist.setCreatedTime(new Date());
        artist.setIsDelete((byte) 0);
        artist.setIntro(this.intro);
        artist.setLastModifiedTime(new Date());
        return artist;
    }

    public void from(Artist artist) {
        this.id = artist.getId();
        this.artistName = artist.getArtistName();
        this.artistOtherName = artist.getArtistOtherName();
        this.intro = artist.getIntro();
        this.artistHeadPhotoBig = artist.getArtistHeadPhotoBig();
        this.artistHeadPhotoSmall = artist.getArtistHeadPhotoSmall();
    }
}
