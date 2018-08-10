package com.wind.springbootmybatistransactionoptimisticlock.controller;

import com.wind.springbootmybatistransactionoptimisticlock.exception.CustomRuntimeException;
import com.wind.springbootmybatistransactionoptimisticlock.service.GoodsInfoService;
import com.wind.springbootmybatistransactionoptimisticlock.service.UserDepositService;
import com.wind.springbootmybatistransactionoptimisticlock.thread.ScrambleGoodsThread;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class IndexController {

    @Resource
    private GoodsInfoService goodsInfoService;

    @Resource
    private UserDepositService userDepositService;

    @GetMapping("/scrambleGoods")
    public void scrambleGoods(){

        int goodsId = 1;

        Thread t1 = new Thread(new ScrambleGoodsThread(goodsId, "lee", goodsInfoService));
        Thread t2 = new Thread(new ScrambleGoodsThread(goodsId, "wind", goodsInfoService));
        Thread t3 = new Thread(new ScrambleGoodsThread(goodsId, "sun", goodsInfoService));

        t1.start();
        t2.start();
        t3.start();
    }

    @GetMapping("/withdrawal")
    public void withdraw(){
        final int depositId = 1;
        Thread t1 = new Thread(() -> {
            String userName = "lee";
            BigDecimal withdrawAmount = new BigDecimal(200.00);
            try{
                userDepositService.withdraw(userName, depositId, withdrawAmount);
            }catch (CustomRuntimeException cre){
                System.out.println(userName + cre.getReason() + cre.getDetail());
            }
        });//lambda表达式
        Thread t2 = new Thread(new Thread(){
            public void run(){
                String userName = "wind";
                BigDecimal withdrawAmount = new BigDecimal(300.00);
                try{
                    userDepositService.withdraw(userName, depositId, withdrawAmount);
                }catch (CustomRuntimeException cre){
                    System.out.println(userName + cre.getReason() + cre.getDetail());
                }
            }
        });
        t1.start();
        t2.start();

//        userDepositService.withdraw("lee", depositId, new BigDecimal("100"));
//        userDepositService.withdraw("wind", depositId, new BigDecimal("200"));
    }

}
