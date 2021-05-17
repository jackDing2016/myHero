package com.wison.learn.myHero.entity;

import lombok.Data;

@Data
public class Hero {

    private Integer id;

    private String name;

    public Hero(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Hero() {
    }
}
