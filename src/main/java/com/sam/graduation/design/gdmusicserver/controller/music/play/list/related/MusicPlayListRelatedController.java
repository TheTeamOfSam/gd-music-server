package com.sam.graduation.design.gdmusicserver.controller.music.play.list.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list.MusicInUserMusicListService;
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
 * @version Created Time:2018/3/22 17:22:17
 */
@RestController
@Api("音乐播放列表接口相关")
@RequestMapping("/gdmusicserver")
public class MusicPlayListRelatedController extends BaseController {

    @Autowired
    private MusicInUserMusicListService musicInUserMusicListService;

    @ApiOperation("获取音乐播放列表接口相关")
    @RequestMapping(value = "/get/music/play/list/@query", method = RequestMethod.GET)
    public Map<String, Object> getMusicPlayList(
            @RequestParam(value = "user_music_list_id", required = false) Long userMusicListId
    ) {
        if (userMusicListId == null) {
            return this.error("用户歌单id不能为空！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;
        try {
            artistSpecialMusicDtos = this.musicInUserMusicListService.findMusicByUserMusicListId(userMusicListId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusicDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistSpecialMusicDtos);
    }

}
