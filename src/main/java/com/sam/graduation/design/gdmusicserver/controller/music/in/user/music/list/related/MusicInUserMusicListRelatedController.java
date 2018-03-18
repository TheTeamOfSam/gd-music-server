package com.sam.graduation.design.gdmusicserver.controller.music.in.user.music.list.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.service.music.in.user.music.list.MusicInUserMusicListService;
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
 * @version Created Time:2018/3/17 15:48:07
 */
@RestController
@Api("用户歌单内歌曲接口相关")
@RequestMapping("/gdmusicserver")
public class MusicInUserMusicListRelatedController extends BaseController {

    @Autowired
    private MusicInUserMusicListService musicInUserMusicListService;

    @ApiOperation("获取我的歌单的单个歌单的歌曲列表接口")
    @RequestMapping(value = "/get/music/in/user/music/list/@query", method = RequestMethod.GET)
    public Map<String, Object> getMusicInUserMusicList(
            @RequestParam(value = "user_id", required = false) Long userId,
            @RequestParam(value = "user_music_list_id", required = false) Long userMusicListId
    ) {
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (userMusicListId == null) {
            return this.error("歌单id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;
        try {
            artistSpecialMusicDtos = this.musicInUserMusicListService.showMyMusicList(userId, userMusicListId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusicDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistSpecialMusicDtos);

    }

}
