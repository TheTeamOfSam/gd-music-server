package com.sam.graduation.design.gdmusicserver.controller.artist.special.music.related;

import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialMusicMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialMusic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 21:57:59
 */
@RestController
@Api("艺人、专辑和音乐接口相关")
@RequestMapping("/gdmusicserver")
public class ArtistSpecialMusicRelatedController extends BaseController {

    @Autowired
    private ArtistSpecialMusicMapper artistSpecialMusicMapper;

    @ApiOperation("根据音乐名获取信息接口")
    @RequestMapping(value = "/artist/special/music/find/like/music/name/@query", method = RequestMethod.GET)
    public Map<String, Object> artistSpecialMusicFindLikeMusicName(
            @RequestParam(value = "musicName", required = false) String musicName
    ){
        List<ArtistSpecialMusic> artistSpecialMusics = this.artistSpecialMusicMapper.selectByMusicName(musicName);

        return this.success(artistSpecialMusics);
    }

}
