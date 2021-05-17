package com.wison.learn.myHero.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wison.learn.myHero.constant.DeleteEnum;
import com.wison.learn.myHero.dto.HeroDTO;
import com.wison.learn.myHero.entity.Hero;
import com.wison.learn.myHero.entity.THero;
import com.wison.learn.myHero.exception.BusinessException;
import com.wison.learn.myHero.mapper.THeroMapper;
import com.wison.learn.myHero.service.ITHeroService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wison.learn.myHero.vo.HeroVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jack
 * @since 2021-05-17
 */
@Service
public class THeroServiceImpl extends ServiceImpl<THeroMapper, THero> implements ITHeroService {

    @Override
    public Boolean addHero(HeroDTO heroDTO) {

        String name = heroDTO.getName();

        THero hero = new THero();
        hero.setName( name );
        save( hero );

        return true;
    }

    @Override
    public Boolean editHero(HeroDTO heroDTO) {

        Integer id = heroDTO.getId();

        if ( id == null ) {
            throw new BusinessException( "id为空" );
        }

        update( new UpdateWrapper<THero>().lambda()
                .eq( THero::getId, id )
                .set( THero::getName, heroDTO.getName() ));

        return null;
    }

    @Override
    public HeroVO queryHero(Integer id) {

        if ( id == null ) {
            throw new BusinessException( "id为空" );
        }

        THero hero = getById( id );
        if ( hero != null ) {
            HeroVO heroVO = new HeroVO();
            BeanUtils.copyProperties( hero, heroVO );
            return heroVO;
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        if ( id == null ) {
            throw new BusinessException( "id为空" );
        }
        update( new UpdateWrapper<THero>().lambda()
                .eq( THero::getId, id )
                .set( THero::getIsDelete, DeleteEnum.yes.getCode())
        );
        return null;
    }

    @Override
    public List<HeroVO> listAll() {
        List<THero> heroList = list( new QueryWrapper<THero>().lambda().eq( THero::getIsDelete, DeleteEnum.no.getCode() ) );

        if ( !CollectionUtils.isEmpty( heroList )) {
            List<HeroVO> heroVOList = new ArrayList<>();
            for ( THero hero : heroList ) {
                HeroVO heroVO = new HeroVO();
                BeanUtils.copyProperties( hero, heroVO );
                heroVOList.add( heroVO );
            }
            return heroVOList;
        }

        return new ArrayList<>();
    }
}
