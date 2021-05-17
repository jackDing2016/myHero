package com.wison.learn.myHero.service;

import com.wison.learn.myHero.dto.HeroDTO;
import com.wison.learn.myHero.entity.THero;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wison.learn.myHero.vo.HeroVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jack
 * @since 2021-05-17
 */
public interface ITHeroService extends IService<THero> {

    Boolean addHero(HeroDTO heroDTO);

    Boolean editHero( HeroDTO heroDTO );

    HeroVO queryHero(Integer id );

    Boolean delete( Integer id );

    List<HeroVO> listAll();

}
