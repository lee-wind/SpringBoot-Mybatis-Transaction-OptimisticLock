package com.wind.springbootmybatistransactionoptimisticlock.dao;

import com.wind.springbootmybatistransactionoptimisticlock.model.UserDeposit;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface UserDepositMapper {
    int deleteByPrimaryKey(Integer depositId);

    int insert(UserDeposit record);

    int insertSelective(UserDeposit record);

    UserDeposit selectByPrimaryKey(Integer depositId);

    int updateByPrimaryKeySelective(UserDeposit record);

    int updateByPrimaryKey(UserDeposit record);

    int withdraw(@Param("depositId") int depositId, @Param("newDepositAmount") BigDecimal newDepositAmount,
                  @Param("newVersion") int newVersion, @Param("currentVersion") int currentVersion);
}