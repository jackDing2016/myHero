package com.wison.learn.myHero.service;

import com.wison.learn.myHero.entity.Hero;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroMockService implements HeroService {
    @Override
    public List<Hero> list() {
        return List.of(
                new Hero(1, "Jack"),
                new Hero(2, "Mary"),
                new Hero(3, "Tom" )
        );
    }
}
