package com.sam.graduation.design.gdmusicserver.controller.artist.special.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialAndNumOfMusicInSpecialDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistSpecialMusicDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.SpecialDto;
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
 * 艺人专辑相关接口
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 13:20:02
 */
@RestController
@Api("艺人专辑接口相关")
@RequestMapping("/gdmusicserver")
public class ArtistSpecialRelatedController extends BaseController {

    @Autowired
    private SpecialService specialService;

    /**
     * 获取对应艺人专辑的接口
     * @param artistId 艺人id
     * @return map
     */
    @ApiOperation("获取对应艺人专辑的接口")
    @RequestMapping(value = "/find/specials/by/artist/id/@query", method = RequestMethod.GET)
    public Map<String, Object> findSpecialsByArtistId(
            @RequestParam(value = "artist_id", required = false) Long artistId
    ) {
        if (artistId == null) {
            return this.error("艺人id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<SpecialDto> specialDtos = null;
        try {
            specialDtos = this.specialService.findByArtistId(artistId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (specialDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(specialDtos);
    }

    /**
     * 根据专辑id查找专辑接口
     * @param specialId 专辑id
     * @return map
     */
    @ApiOperation("根据专辑id查找专辑接口")
    @RequestMapping(value = "/find/special/by/special/id/@query", method = RequestMethod.GET)
    public Map<String, Object> findSpecialBySpecialId(
            @RequestParam(value = "special_id", required = false) Long specialId
    ) {
        if (specialId == null){
            return this.error("专辑id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        ArtistSpecialAndNumOfMusicInSpecialDto artistSpecialAndNumOfMusicInSpecialDto = null;
        try {
            artistSpecialAndNumOfMusicInSpecialDto = this.specialService.findBySpecialId(specialId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialAndNumOfMusicInSpecialDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistSpecialAndNumOfMusicInSpecialDto);
    }

    /**
     * 根据专辑id获取专辑内歌曲列表的接口
     * @param specialId 专辑id
     * @return map
     */
    @ApiOperation("根据专辑id获取专辑内歌曲列表的接口")
    @RequestMapping(value = "/find/music/in/special/by/special/id/@query", method = RequestMethod.GET)
    public Map<String, Object> findMusicInSpecialBySpecialId(
            @RequestParam(value = "special_id", required = false) Long specialId
    ) {
        if (specialId == null) {
            return this.error("专辑id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        List<ArtistSpecialMusicDto> artistSpecialMusicDtos = null;
        try {
            artistSpecialMusicDtos = this.specialService.findMusicInSpecialBySpecialId(specialId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistSpecialMusicDtos == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistSpecialMusicDtos);
    }

}
