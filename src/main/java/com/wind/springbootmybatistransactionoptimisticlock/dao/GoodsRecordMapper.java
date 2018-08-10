package com.wind.springbootmybatistransactionoptimisticlock.dao;

import com.wind.springbootmybatistransactionoptimisticlock.model.GoodsRecord;

public interface GoodsRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(GoodsRecord record);

    int insertSelective(GoodsRecord record);

    GoodsRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(GoodsRecord record);

    int updateByPrimaryKey(GoodsRecord record);

    int insertGoodsRecord(int goodsId, String username);
}