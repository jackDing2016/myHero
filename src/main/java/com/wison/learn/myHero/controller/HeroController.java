package com.wison.learn.myHero.controller;

import com.wison.learn.myHero.dto.HeroDTO;
import com.wison.learn.myHero.dto.ResultData;
import com.wison.learn.myHero.service.ITHeroService;
import com.wison.learn.myHero.vo.HeroVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( "/hero" )
@RestController
public class HeroController {

//    @Autowired
//    private HeroService heroService;

    @Autowired
    private ITHeroService heroService;

    @PutMapping
    @ResponseBody
    ResultData<String> addHero(@RequestBody HeroDTO heroDTO) {
        heroService.addHero( heroDTO );
        return new ResultData<String>();
    }

    @PostMapping
    ResultData<String> editHero(@RequestBody HeroDTO heroDTO) {
        heroService.editHero( heroDTO );
        return new ResultData<String>();
    }

    @GetMapping
    ResultData<HeroVO> queryHero( @RequestParam Integer id ) {
        return new ResultData<>(heroService.queryHero(id));
    }

    @GetMapping( "/listAll" )
    ResultData<List<HeroVO>> listAll() {
        return new ResultData<>( heroService.listAll() );
    }

//    @GetMapping("/list")
//    @ResponseBody
//    List<Hero> list(){
//        return heroService.list();
//    }

}
