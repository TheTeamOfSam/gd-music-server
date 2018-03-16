package com.sam.graduation.design.gdmusicserver.controller.user.music.list.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserMusicListDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserUserMusicListAndMusicInItDto;
import com.sam.graduation.design.gdmusicserver.service.user.music.list.UserMusicListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/13 19:19:26
 */
@RestController
@Api("用户歌单相关接口")
@RequestMapping("/gdmusicserver")
public class UserMusicListRelatedController extends BaseController {

    @Autowired
    private UserMusicListService userMusicListService;

    @ApiOperation("用户创建歌单")
    @RequestMapping(value = "/user/music/list/@create", method = RequestMethod.POST)
    public Map<String, Object> userMusicListCreate(
            @RequestParam(value = "user_id", required = false) Long userId,
            @RequestParam(value = "music_list_name", required = false) String musicListName
    ) {
        if (StringUtils.isBlank(String.valueOf(userId.longValue()))) {
            return this.error("亲，传入的id是空的", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (StringUtils.isBlank(musicListName)) {
            return this.error("亲，歌单名不能为空！", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }

        UserMusicListDto userMusicListDto = new UserMusicListDto();
        userMusicListDto.setUserId(userId);
        userMusicListDto.setMusicListName(musicListName);
        userMusicListDto.setMusicListPhoto("");
        userMusicListDto.setIntro("");
        userMusicListDto.setGenerateTime(new Date());

        MessageDto messageDto = null;
        try {
            messageDto = this.userMusicListService.userMusicListCreate(userMusicListDto);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (messageDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        if (!messageDto.isSuccess()) {
            return this.error(messageDto.getMessage(), ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        return this.success(messageDto);
    }

    @ApiOperation("根据用户歌单名查询歌单接口")
    @RequestMapping(value = "/find/like/user/music/list/name/@query", method = RequestMethod.GET)
    public Map<String, Object> findLikeUserMusicListName(
            @RequestParam(value = "user_music_list_name", required = false) String userMusicListName
    ) {
        if (StringUtils.isBlank(userMusicListName)) {
            return this.error("搜索的歌单名不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<UserUserMusicListAndMusicInItDto> userUserMusicListAndMusicInItDtos = null;
        try {
            userUserMusicListAndMusicInItDtos = this.userMusicListService.findListUserMusicListName(userMusicListName);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userUserMusicListAndMusicInItDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userUserMusicListAndMusicInItDtos);
    }

    @ApiOperation("根据用户id查找创建的歌单的信息")
    @RequestMapping(value = "/find/user/music/list/by/user/id/@query", method = RequestMethod.GET)
    public Map<String, Object> findUserMusicListByUserId(
            @RequestParam(value = "user_id", required = false) Long userID
    ) {
        if (StringUtils.isBlank(String.valueOf(userID.longValue()))) {
            return this.error("亲，id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<UserUserMusicListAndMusicInItDto> userUserMusicListAndMusicInItDtos = null;
        try {
            userUserMusicListAndMusicInItDtos = this.userMusicListService.findUserMusicListByUserId(userID);
        } catch (Exception e) {
            logger.error("e:{}.",e);
        }
        if (userUserMusicListAndMusicInItDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userUserMusicListAndMusicInItDtos);
    }

}
