package com.wind.springbootmybatistransactionoptimisticlock.service.impl;

import com.wind.springbootmybatistransactionoptimisticlock.dao.UserDepositMapper;
import com.wind.springbootmybatistransactionoptimisticlock.exception.CustomRuntimeException;
import com.wind.springbootmybatistransactionoptimisticlock.model.UserDeposit;
import com.wind.springbootmybatistransactionoptimisticlock.service.UserDepositService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class UserDepositServiceImpl implements UserDepositService {

    @Resource
    private UserDepositMapper userDepositMapper;

    @Override
    public UserDeposit getDepositById(int depositId) {

        return userDepositMapper.selectByPrimaryKey(depositId);
    }

    @Override
    public String withdraw(String userName, int depositId, BigDecimal withdrawAmount) {

        UserDeposit userDeposit = getDepositById(depositId);

        BigDecimal currentDepositAmount = userDeposit.getDepositAmount();
        int currentVersion = userDeposit.getVersion();
        int newVersion = currentVersion + 1;
        System.out.println(userName + "取款前金额：" + currentDepositAmount);

        BigDecimal newDepositAmount = currentDepositAmount.subtract(withdrawAmount);
        System.out.println(userName + "取款后金额为：" + newDepositAmount);

        int withdrawRow = userDepositMapper.withdraw(depositId, newDepositAmount, newVersion, currentVersion);

        if(withdrawRow == 0){
            System.out.println(userName + "取款操作没有成功");
            throw new CustomRuntimeException("取款失败，", "取款中有人正在取款");
        }

        return userName + "取款成功";
    }
}
