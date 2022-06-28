package com.wink.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wink.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
