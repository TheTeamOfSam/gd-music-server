package com.sam.graduation.design.gdmusicserver.controller.music.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.service.music.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/11 17:01:33
 */
@RestController
@Api("音乐相关接口")
@RequestMapping("/gdmusicserver")
public class MusicRelatedController extends BaseController {

    @Autowired
    private MusicService musicService;

    /**
     * 一键更新音乐播放时长
     * @return
     */
    @ApiOperation("一键更新音乐播放时长接口")
    @RequestMapping(value = "/music/service/one/button/to/update/duration/@update", method = RequestMethod.POST)
    public Map<String, Object> musicServiceOneBtnToUpdateMusicDuration() {

        MessageDto messageDto = null;
        try {
            messageDto = this.musicService.oneBtnToUpdateDuration();
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (messageDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(messageDto);

    }

}
