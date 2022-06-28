package com.wink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wink.domain.Car;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper extends BaseMapper<Car> {

    @Select("select * from tb_car where user_id=#{uid}")
    List<Car> showByUserId(@Param("uid") Integer id);
}
