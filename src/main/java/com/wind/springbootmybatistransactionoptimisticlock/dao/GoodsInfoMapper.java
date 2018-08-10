package com.wind.springbootmybatistransactionoptimisticlock.dao;

import com.wind.springbootmybatistransactionoptimisticlock.model.GoodsInfo;

public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    int reduceGoods(int goodsId);
}