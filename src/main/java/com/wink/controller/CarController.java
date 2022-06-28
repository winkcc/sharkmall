package com.wink.controller;

import com.wink.domain.Car;
import com.wink.domain.CarDetail;
import com.wink.domain.Goods;
import com.wink.mapper.GoodsMapper;
import com.wink.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService cs;
    @Autowired
    GoodsMapper gm;

    @GetMapping("/user/cart")
    public String selectByid(HttpSession session,Integer id){
        //所有购物列表
        List<Car> cars= cs.showUserAll(id);
        List<CarDetail> cd=new ArrayList<CarDetail>();


        for (Car c:cars) {
            //通过购物单获取订单详细
            Goods goods=gm.selectById(c.getGoodsId());
            CarDetail carDetail = new CarDetail();
            carDetail.setName(goods.getGoodsName());
            carDetail.setNum(1);
            carDetail.setComment(goods.getGoodsComment());
            carDetail.setPrice(goods.getGoodsPrice());
            cd.add(carDetail);
        }

        session.setAttribute("carDetail",cd);

        return "user/cart";
    }

}
