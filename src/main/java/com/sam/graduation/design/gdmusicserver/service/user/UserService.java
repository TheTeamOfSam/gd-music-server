package com.sam.graduation.design.gdmusicserver.service.user;

import com.sam.graduation.design.gdmusicserver.controller.dto.MessageDto;
import com.sam.graduation.design.gdmusicserver.controller.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author sam199510 273045049@qq.com
 * @version 创建时间：2018/2/28 15:17:54
 */
public interface UserService {
    
    UserDto userRegister(UserDto dto);

    UserDto userLogin(UserDto dto);

    UserDto userInfoGet(Long userID);

    UserDto userBasicInfoUpdate(UserDto dto);

    MessageDto userHeadPhotoUpdate(Long userID, MultipartFile headPhoto) throws IOException;

}
