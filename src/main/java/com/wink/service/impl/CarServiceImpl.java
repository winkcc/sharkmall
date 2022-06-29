package com.wink.service.impl;

import com.wink.domain.Car;
import com.wink.mapper.CarMapper;
import com.wink.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper cm;

    @Override
    public List<Car> showUserAll(Integer id) {

        return cm.showByUserId(id);
    }

    @Override
    public Car updatenumCar(Integer uid, Integer pid) {
        return cm.updatenumCar(uid, pid);
    }
}
