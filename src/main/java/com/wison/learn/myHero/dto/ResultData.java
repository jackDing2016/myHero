package com.wison.learn.myHero.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultData<T> {
    private T data;
    // result code 0 success 1-fail
    private int code = 0;

    private String errMsg;

    public ResultData(int code) {
        this.code = code;
    }

    public ResultData(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public ResultData(T data) {
        this.data = data;
    }
}
