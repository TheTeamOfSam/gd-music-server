package com.sam.graduation.design.gdmusicserver.user.music.list.test;

import com.alibaba.fastjson.JSON;
import com.sam.graduation.design.gdmusicserver.GdMusicServerApplication;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list.MusicInUserMusicListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/4/29 15:42:33
 */
@SpringBootTest(classes = GdMusicServerApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMusicListTest {

    @Autowired
    MusicInUserMusicListService musicInUserMusicListService;


    @Test
    public void testGetUserMusicList() {
        Long userMusicListId = 2L;
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = this.musicInUserMusicListService.findMusicByUserMusicListId(userMusicListId);
        System.out.println(JSON.toJSONString(artistSpecialMusicDtos, true));
    }
}