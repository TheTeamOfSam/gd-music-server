package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByEmail(String email);

    User selectByEmailAndPassword(User record);

    List<User> selectLikeNickname(
            @Param("nickname") String nickname
    );
}