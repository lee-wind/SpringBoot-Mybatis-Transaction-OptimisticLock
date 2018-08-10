package com.wind.springbootmybatistransactionoptimisticlock;

import com.wind.springbootmybatistransactionoptimisticlock.model.GoodsInfo;
import com.wind.springbootmybatistransactionoptimisticlock.service.GoodsInfoService;
import com.wind.springbootmybatistransactionoptimisticlock.thread.ScrambleGoodsThread;
import com.wind.springbootmybatistransactionoptimisticlock.util.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisTransactionOptimisticlockApplicationTests {

    @Test
    public void contextLoads() {
    }

}
