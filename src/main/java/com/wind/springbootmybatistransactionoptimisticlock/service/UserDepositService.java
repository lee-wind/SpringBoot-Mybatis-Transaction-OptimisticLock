package com.wind.springbootmybatistransactionoptimisticlock.service;

import com.wind.springbootmybatistransactionoptimisticlock.model.UserDeposit;

import java.math.BigDecimal;

public interface UserDepositService {

    UserDeposit getDepositById(int depositId);

    String withdraw(String userName, int depositId, BigDecimal withdrawAmount);
}
