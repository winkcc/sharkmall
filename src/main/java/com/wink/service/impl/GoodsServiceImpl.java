package com.wink.service.impl;

import com.wink.domain.Goods;
import com.wink.mapper.CategoryMapper;
import com.wink.mapper.GoodsMapper;
import com.wink.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper gm;



    @Override
    public List<Goods> selectAll() {

        return gm.selectList(null);
    }

    @Override
    public Goods selectByName(String name) {

        return gm.selectByName(name);
    }

    @Override
    public List<Goods> selectTypeAll(Integer id) {

        return gm.selectByTypeId(id);
    }

    @Override
    public Goods selectById(Integer id) {
        return gm.selectById(id);
    }
}
