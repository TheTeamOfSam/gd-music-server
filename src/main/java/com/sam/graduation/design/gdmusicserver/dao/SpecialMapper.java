package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.Special;

public interface SpecialMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Special record);

    int insertSelective(Special record);

    Special selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Special record);

    int updateByPrimaryKey(Special record);
}