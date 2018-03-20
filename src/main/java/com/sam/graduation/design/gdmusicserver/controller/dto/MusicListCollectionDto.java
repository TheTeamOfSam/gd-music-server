package com.sam.graduation.design.gdmusicserver.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicListCollection;

import java.util.Date;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/20 16:59:20
 */
public class MusicListCollectionDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_music_list_id")
    private Long userMusicListId;

    @JsonProperty("collected_time")
    private Date collectedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserMusicListId() {
        return userMusicListId;
    }

    public void setUserMusicListId(Long userMusicListId) {
        this.userMusicListId = userMusicListId;
    }

    public Date getCollectedTime() {
        return collectedTime;
    }

    public void setCollectedTime(Date collectedTime) {
        this.collectedTime = collectedTime;
    }

    public MusicListCollection to() {
        MusicListCollection musicListCollection = new MusicListCollection();
        musicListCollection.setUserId(this.userId);
        musicListCollection.setUserMusicListId(this.userMusicListId);
        musicListCollection.setCollectedTime(this.collectedTime);
        musicListCollection.setCreatedTime(new Date());
        musicListCollection.setLastModifiedTime(new Date());
        musicListCollection.setIsDelete((byte) 0);
        return musicListCollection;
    }

    public void from(MusicListCollection musicListCollection) {
        this.id = musicListCollection.getId();
        this.userId = musicListCollection.getUserId();
        this.userMusicListId = musicListCollection.getUserMusicListId();
        this.collectedTime = musicListCollection.getCollectedTime();
    }

}
