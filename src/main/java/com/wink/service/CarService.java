package com.wink.service;

import com.wink.domain.Car;

import java.util.List;

public interface CarService {

    List<Car> showUserAll(Integer id);

    Car updatenumCar(Integer uid,Integer pid);
}
