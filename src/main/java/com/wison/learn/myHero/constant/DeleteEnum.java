package com.wison.learn.myHero.constant;

import lombok.Getter;

@Getter
public enum DeleteEnum {

    yes( 1, "已删除" ),
    no(0, "未删除");

    private final int code;
    private final String name;

    DeleteEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
