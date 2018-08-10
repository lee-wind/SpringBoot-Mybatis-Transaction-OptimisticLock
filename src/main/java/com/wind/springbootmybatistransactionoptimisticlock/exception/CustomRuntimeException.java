package com.wind.springbootmybatistransactionoptimisticlock.exception;

public class CustomRuntimeException extends RuntimeException{

    private String reason;
    private String detail;

    public CustomRuntimeException(String reason, String detail) {

        super(reason + ", " +detail);
        this.reason = reason;
        this.detail = detail;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
