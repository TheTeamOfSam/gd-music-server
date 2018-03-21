package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.UserAndCreatedMLAndCollectedML;
import org.apache.ibatis.annotations.Param;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2018/3/21 09:49:13
 */
public interface UserAndCreatedMLAndCollectedMLMapper {

    UserAndCreatedMLAndCollectedML selectUserAndCreatedMLAndCollectedMLByUserId(
            @Param("user_id") Long userId
    );

}
