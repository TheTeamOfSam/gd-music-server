package com.sam.graduation.design.gdmusicserver.dao;

import com.sam.graduation.design.gdmusicserver.model.pojo.ListenHistory;

public interface ListenHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ListenHistory record);

    int insertSelective(ListenHistory record);

    ListenHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ListenHistory record);

    int updateByPrimaryKey(ListenHistory record);
}