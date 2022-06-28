package com.wink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wink.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from tb_user where us_username=#{username}")
    User selectByUsername(@Param("username") String username);
}
