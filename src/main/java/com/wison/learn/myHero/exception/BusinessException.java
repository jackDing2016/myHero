package com.wison.learn.myHero.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private String errCode;

    private String errMsg;

    public BusinessException(String errMsg) {
        this.errMsg = errMsg;
    }

    public BusinessException(String message, String errCode) {
        super(message);
        this.errCode = errCode;
    }
}
