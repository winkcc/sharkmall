package com.wink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wink.domain.Goods;
import com.wink.domain.Order;
import com.wink.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("select * from tb_goods where goods_name=#{name}")
    Goods selectByName(@Param("name") String name);

    @Select("select * from tb_goods where category_id=#{id}")
    List<Goods> selectByTypeId(@Param("id") Integer id);

    @Select("select * from tb_goods where goods_name like CONCAT('%',#{name},'%')")
    List<Goods> selectAllbyname(@Param("name") String name);

}
