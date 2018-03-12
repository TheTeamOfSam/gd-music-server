package com.sam.graduation.design.gdmusicserver.controller.artist.special.music.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.dao.ArtistSpecialMusicMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.ArtistSpecialMusic;
import com.sam.graduation.design.gdmusicserver.service.music.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
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
    private MusicService musicService;

    @ApiOperation("根据音乐名获取信息接口")
    @RequestMapping(value = "/artist/special/music/find/like/music/name/@query", method = RequestMethod.GET)
    public Map<String, Object> artistSpecialMusicFindLikeMusicName(
            @RequestParam(value = "music_name", required = false) String musicName
    ) {
        if (StringUtils.isBlank(musicName)) {
            return this.error("歌曲名不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;
        try {
            artistSpecialMusicDtos = this.musicService.findLikeMusicName(musicName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusicDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistSpecialMusicDtos);
    }

}
