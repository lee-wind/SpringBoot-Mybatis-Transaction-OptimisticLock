package com.wind.springbootmybatistransactionoptimisticlock.service.impl;

import com.wind.springbootmybatistransactionoptimisticlock.dao.GoodsInfoMapper;
import com.wind.springbootmybatistransactionoptimisticlock.dao.GoodsRecordMapper;
import com.wind.springbootmybatistransactionoptimisticlock.exception.CustomRuntimeException;
import com.wind.springbootmybatistransactionoptimisticlock.model.GoodsInfo;
import com.wind.springbootmybatistransactionoptimisticlock.model.GoodsRecord;
import com.wind.springbootmybatistransactionoptimisticlock.service.GoodsInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    @Resource
    private GoodsRecordMapper goodsRecordMapper;

    @Override
    public GoodsInfo getGoodsInfo(int goodsId){

        return goodsInfoMapper.selectByPrimaryKey(goodsId);
    }


    @Override
    @Transactional
    public String ScrambleGoods(int goodsId, String userName) throws CustomRuntimeException{

        try{
            GoodsRecord goodsRecord = new GoodsRecord();
            goodsRecord.setGoodsId(goodsId);
            goodsRecord.setUserName(userName);
            int insertRow = goodsRecordMapper.insertSelective(goodsRecord);
            if(insertRow == 1){
                System.out.println("插入" + userName + "抢购记录成功");
            }
        }catch (Exception e){
            throw new CustomRuntimeException("抢购失败", "请勿重复抢购");
        }

        int reduceRow = goodsInfoMapper.reduceGoods(goodsId);

        if(reduceRow == 0){
            System.out.println("减库存失败" + userName + "抢购记录回滚");
            throw new CustomRuntimeException("抢购失败", "已无库存");
        }

        System.out.println(userName + "抢购" + goodsId + "成功！");

        return "抢购成功";
    }
}
