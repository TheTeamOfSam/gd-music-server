package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicInUserMusicList;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/17 14:02:13
 */
public class MusicInUserMusicListDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_music_list_id")
    private Long userMusicListId;

    @JsonProperty("music_id")
    private Long musicId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("collected_time")
    private Date collectedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserMusicListId() {
        return userMusicListId;
    }

    public void setUserMusicListId(Long userMusicListId) {
        this.userMusicListId = userMusicListId;
    }

    public Long getMusicId() {
        return musicId;
    }

    public void setMusicId(Long musicId) {
        this.musicId = musicId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(Date collectedTime) {
        this.collectedTime = collectedTime;
    }

    public MusicInUserMusicList to() {
        MusicInUserMusicList musicInUserMusicList = new MusicInUserMusicList();
        musicInUserMusicList.setId(this.id);
        musicInUserMusicList.setUserMusicListId(this.userMusicListId);
        musicInUserMusicList.setMusicId(this.musicId);
        musicInUserMusicList.setUserId(this.userId);
        musicInUserMusicList.setCollectedTime(this.collectedTime);
        return musicInUserMusicList;
    }

    public void from(MusicInUserMusicList musicInUserMusicList) {
        this.id = musicInUserMusicList.getId();
        this.userMusicListId = musicInUserMusicList.getUserMusicListId();
        this.musicId = musicInUserMusicList.getMusicId();
        this.userId = musicInUserMusicList.getUserId();
        this.collectedTime = musicInUserMusicList.getCollectedTime();
    }
}
