package com.sam.graduation.design.gdmusicserver.controller.music.list.collection.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.MusicListCollectionDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserUserMusicListAndMusicInItDto;
import com.sam.graduation.design.gdmusicserver.dao.MusicListCollectionMapper;
import com.sam.graduation.design.gdmusicserver.dao.UserMusicListMapper;
import com.sam.graduation.design.gdmusicserver.model.pojo.MusicListCollection;
import com.sam.graduation.design.gdmusicserver.model.pojo.UserMusicList;
import com.sam.graduation.design.gdmusicserver.service.music.list.collection.MusicListCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 收藏音乐相关接口
 *
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/20 17:10:14
 */
@RestController
@Api("收藏音乐相关接口")
@RequestMapping("/gdmusicserver")
public class MusicListCollectionRelatedController extends BaseController {

    @Autowired
    private UserMusicListMapper userMusicListMapper;

    @Autowired
    private MusicListCollectionMapper musicListCollectionMapper;

    @Autowired
    private MusicListCollectionService musicListCollectionService;

    /**
     * 收藏别的用户创建的歌单的接口
     *
     * @param userId          用户id
     * @param userMusicListId 音乐列表id
     * @return
     */
    @ApiOperation("收藏别的用户创建的歌单的接口")
    @RequestMapping(value = "/collect/other/user/music/list/@collect", method = RequestMethod.POST)
    public Map<String, Object> collectOtherUserMusicList(
            @RequestParam(value = "user_id", required = false) Long userId,
            @RequestParam(value = "user_music_list_id", required = false) Long userMusicListId
    ) {
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (userMusicListId == null) {
            return this.error("用户歌单id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        UserMusicList userMusicList = this.userMusicListMapper.selectByPrimaryKey(userMusicListId);
        if (userMusicList.getUserId().equals(userId)) {
            return this.error("自己的歌单不能收藏", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        MusicListCollection musicListCollection = this.musicListCollectionMapper
                .selectMusicListCollectionByUserIdAndUserMusicListId(userId, userMusicListId);
        if (musicListCollection != null) {
            return this.error("你已收藏该歌单", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        MessageDto messageDto = null;

        MusicListCollectionDto musicListCollectionDto = new MusicListCollectionDto();
        musicListCollectionDto.setUserId(userId);
        musicListCollectionDto.setUserMusicListId(userMusicListId);
        musicListCollectionDto.setCollectedTime(new Date());

        try {
            messageDto = this.musicListCollectionService.collectOtherUserMusicListIntoMyCollect(musicListCollectionDto);
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

    /**
     * 显示收藏别的用户创建的歌单的接口
     * @param userId 用户id
     * @return map
     */
    @ApiOperation("显示收藏别的用户创建的歌单的接口")
    @RequestMapping(value = "/show/collected/other/user/music/list/by/user/id/@query", method = RequestMethod.GET)
    public Map<String, Object> showCollectedOtherUserMusicListByUserId(
            @RequestParam(value = "user_id", required = false) Long userId
    ) {
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<UserUserMusicListAndMusicInItDto> userUserMusicListAndMusicInItDtos = null;
        try {
            userUserMusicListAndMusicInItDtos = this.musicListCollectionService.showMyCollectByUserId(userId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (userUserMusicListAndMusicInItDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(userUserMusicListAndMusicInItDtos);
    }

    /**
     * 取消收藏别的用户创建的歌单的接口
     * @param userId 用户id
     * @param userMusicListId 用户音乐列表id
     * @return map
     */
    @ApiOperation("取消收藏别的用户创建的歌单的接口")
    @RequestMapping(value = "/un/collect/other/user/music/list/@uncollect", method = RequestMethod.GET)
    public Map<String, Object> unCollectOtherUserMusicList(
            @RequestParam(value = "user_id", required = false) Long userId,
            @RequestParam(value = "user_music_list_id", required = false) Long userMusicListId
    ) {
        if (userId == null) {
            return this.error("用户id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        if (userMusicListId == null) {
            return this.error("用户歌单id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        MessageDto messageDto = null;
        try {
            messageDto = this.musicListCollectionService
                    .unCollectOtherUserMusicListIntoMyCollect(userId, userMusicListId);
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


}
