package com.wind.springbootmybatistransactionoptimisticlock.thread;

import com.wind.springbootmybatistransactionoptimisticlock.exception.CustomRuntimeException;
import com.wind.springbootmybatistransactionoptimisticlock.service.GoodsInfoService;

public class ScrambleGoodsThread implements Runnable{

    private int goodsId;
    private String userName;
    private GoodsInfoService goodsInfoService;

    public ScrambleGoodsThread(int goodsId, String userName, GoodsInfoService goodsInfoService) {
        this.goodsId = goodsId;
        this.userName = userName;
        this.goodsInfoService = goodsInfoService;
    }

    @Override
    public void run() {
        try{
            goodsInfoService.ScrambleGoods(goodsId, userName);
        }catch(CustomRuntimeException cre){
            System.out.println(userName + "抢购" + goodsId + ", " + cre.getReason() + ", " + cre.getDetail());
        }
    }
}
