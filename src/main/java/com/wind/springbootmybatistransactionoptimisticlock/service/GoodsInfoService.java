package com.wind.springbootmybatistransactionoptimisticlock.service;

import com.wind.springbootmybatistransactionoptimisticlock.exception.CustomRuntimeException;
import com.wind.springbootmybatistransactionoptimisticlock.model.GoodsInfo;
import org.springframework.transaction.annotation.Transactional;

public interface GoodsInfoService {

    GoodsInfo getGoodsInfo(int goodsId);

    String ScrambleGoods(int goodsId, String userName) throws CustomRuntimeException;
}
