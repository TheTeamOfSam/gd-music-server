package com.sam.graduation.design.gdmusicserver.controller.artist.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
import com.sam.graduation.design.gdmusicserver.controller.dto.ArtistDto;
import com.sam.graduation.design.gdmusicserver.service.artist.ArtistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 12:54:18
 */
@RestController
@Api("艺人相关接口")
@RequestMapping(value = "/gdmusicserver")
public class ArtistRelatedController extends BaseController {

    @Autowired
    private ArtistService artistService;

    @ApiOperation("根据艺人id获取艺人信息接口")
    @RequestMapping(value = "/find/artist/by/artist/id/@query", method = RequestMethod.GET)
    public Map<String, Object> findArtistByArtistId(
            @RequestParam(value = "artist_id", required = false) Long artistId
    ) {
        if (StringUtils.isBlank(String.valueOf(artistId.longValue()))) {
            return this.error("艺人id不能为空", ServiceResultType.RESULT_TYPE_SERVICE_ERROR);
        }
        ArtistDto artistDto = null;
        try {
            artistDto = this.artistService.findByArtistId(artistId);
        } catch (Exception e) {
            logger.error("e:{}", e);
        }
        if (artistDto == null) {
            return this.error("系统异常", ServiceResultType.RESULT_TYPE_SYSTEM_ERROR);
        }
        return this.success(artistDto);
    }

}
