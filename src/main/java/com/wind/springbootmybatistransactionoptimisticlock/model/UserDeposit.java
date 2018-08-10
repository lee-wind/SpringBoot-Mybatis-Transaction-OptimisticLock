package com.wind.springbootmybatistransactionoptimisticlock.model;

import java.math.BigDecimal;

public class UserDeposit {
    private Integer depositId;

    private BigDecimal depositAmount;

    private Integer version;

    public Integer getDepositId() {
        return depositId;
    }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}