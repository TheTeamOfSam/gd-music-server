package com.sam.graduation.design.gdmusicserver.controller.artist.special.related;

import com.sam.graduation.design.gdmusicserver.constvalue.ServiceResultType;
import com.sam.graduation.design.gdmusicserver.controller.base.BaseController;
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
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/18 13:20:02
 */
@RestController
@Api("艺人专辑接口相关")
@RequestMapping("/gdmusicserver")
public class ArtistSpecialRelatedController extends BaseController {

    @Autowired
    private SpecialService specialService;

    @ApiOperation("获取对应艺人专辑的接口")
    @RequestMapping(value = "/find/specials/by/artist/id/@query", method = RequestMethod.GET)
    public Map<String, Object> findSpecialsByArtistId(
            @RequestParam(value = "artist_id", required = false) Long artistId
    ) {
        if (StringUtils.isBlank(String.valueOf(artistId.longValue()))) {
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

}
