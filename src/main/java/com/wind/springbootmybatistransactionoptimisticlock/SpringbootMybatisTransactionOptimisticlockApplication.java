package com.wind.springbootmybatistransactionoptimisticlock;

import com.wind.springbootmybatistransactionoptimisticlock.dao.GoodsInfoMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@EnableTransactionManagement
@MapperScan("com.wind.springbootmybatistransactionoptimisticlock.dao")
@SpringBootApplication
public class SpringbootMybatisTransactionOptimisticlockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisTransactionOptimisticlockApplication.class, args);
    }
}
