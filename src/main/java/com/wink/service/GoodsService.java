package com.wink.service;


import com.wink.domain.Goods;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GoodsService {
    List<Goods> selectAll();

    Goods selectByName(String name);

    List<Goods> selectTypeAll(Integer id);
}
