package com.sam.graduation.design.gdmusicserver.controller.artist.special.music.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.service.artist.ArtistService;
import com.sam.graduation.design.gdmusicserver.service.music.MusicService;
import com.sam.graduation.design.gdmusicserver.service.special.SpecialService;
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
 * 艺人、专辑和音乐相关控制器
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 21:57:59
 */
@RestController
@Api("艺人、专辑和音乐接口相关")
@RequestMapping("/gdmusicserver")
public class ArtistSpecialMusicRelatedController extends BaseController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private MusicService musicService;

    @Autowired
    private SpecialService specialService;

    /**
     * 根据音乐名获取信息接口
     *
     * @param musicName 音乐名称
     * @return map
     */
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

    /**
     * 根据歌手名获取信息接口
     *
     * @param artistName 艺人姓名
     * @return map
     */
    @ApiOperation("根据歌手名获取信息接口")
    @RequestMapping(value = "/artist/special/music/find/like/artist/name/@query", method = RequestMethod.GET)
    public Map<String, Object> artistSpecialMusicFindLikeArtistName(
            @RequestParam(value = "artist_name", required = false) String artistName
    ) {
        if (StringUtils.isBlank(artistName)) {
            return this.error("歌手名不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<ArtistDto> artistDtos = null;
        try {
            artistDtos = this.artistService.findLikeArtistName(artistName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistDtos);
    }

    /**
     * 根据专辑名获取信息接口
     * @param specialName 专辑名称
     * @return map
     */
    @ApiOperation("根据专辑名获取信息接口")
    @RequestMapping(value = "/artist/special/music/find/like/special/name/@query", method = RequestMethod.GET)
    public Map<String, Object> artistSpecialMusicFindLikeSpecialName(
            @RequestParam(value = "special_name", required = false) String specialName
    ) {
        if (StringUtils.isBlank(specialName)) {
            return this.error("专辑名不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<ArtistSpecialDto> artistSpecialDtos = null;
        try {
            artistSpecialDtos = this.specialService.findASLikeSpecialName(specialName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistSpecialDtos);
    }

    /**
     * 根据音乐id获取单曲信息的接口
     * @param musicId 音乐id
     * @return map
     */
    @ApiOperation("根据音乐id获取单曲信息的接口")
    @RequestMapping(value = "/find/music/by/music/id/@query", method = RequestMethod.GET)
    public Map<String, Object> findMusicByMusicId(
            @RequestParam(value = "music_id", required = false) Long musicId
    ) {
        if (musicId == null) {
            return this.error("音乐id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        ArtistSpecialMusicDto artistSpecialMusicDto = null;
        try {
            artistSpecialMusicDto = this.musicService.findMusicByMusicId(musicId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusicDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistSpecialMusicDto);
    }

}
