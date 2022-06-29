package com.wink.controller;

import com.google.gson.Gson;
import com.wink.domain.Car;
import com.wink.domain.CarDetail;
import com.wink.domain.Goods;
import com.wink.domain.User;
import com.wink.mapper.CarMapper;
import com.wink.mapper.GoodsMapper;
import com.wink.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService cs;
    @Autowired
    CarMapper cm;
    @Autowired
    GoodsMapper gm;

    static int carid=1;
    static Gson gson;

    //通过用户名查找此用户的购物车
    @GetMapping("/user/cart")
    public String selectByid(HttpSession session, Integer id) {
        //所有购物列表
        List<Car> cars = cs.showUserAll(id);
        List<CarDetail> cd = new ArrayList<CarDetail>();
        int total = 0;

        for (Car c : cars) {
            //通过购物单获取订单详细
            Goods goods = gm.selectById(c.getGoodsId());
            CarDetail carDetail = new CarDetail();
            carDetail.setPid(c.getCarId());
            carDetail.setGid(c.getGoodsId());
            carDetail.setName(goods.getGoodsName());
            carDetail.setNum((int) c.getCarNum());
            carDetail.setComment(goods.getGoodsComment());
            carDetail.setPrice(goods.getGoodsPrice());
            cd.add(carDetail);
            total += (int) c.getCarNum() * goods.getGoodsPrice();
        }
        session.setAttribute("total", total);
        session.setAttribute("carDetail", cd);
        return "user/cart";
    }

    //增加购物车里的商品数量
    @GetMapping("user/add")
    public String add(Integer pid, Integer uid) {

        Car car = cs.updatenumCar(uid, pid);
        System.out.println(car);
        car.setCarNum(car.getCarNum() + 1);
        cm.updateById(car);

        String str = "redirect:/user/cart?id=" + uid;

        return str;
    }
    //减少购物车里的商品数量
    @GetMapping("user/sub")
    public String sub(Integer pid, Integer uid) {

        Car car = cs.updatenumCar(uid, pid);
        car.setCarNum(car.getCarNum() - 1);
        cm.updateById(car);

        String str = "redirect:/user/cart?id=" + uid;

        return str;
    }

    //增加商品到购物车
    @PostMapping("addgoods")
    @ResponseBody
    public void addGoods(@RequestParam(value = "uid") Integer uid, @RequestParam(value = "gid") Integer gid) {
        Car car = cm.updatenumCar(uid, gid);
        if (car != null) {
            car.setCarNum(car.getCarNum() + 1);
            cm.updateById(car);
        } else {
            car = new Car();
            car.setCarId(carid);
            carid+=1;
            car.setUserId(uid);
            car.setGoodsId(gid);
            car.setCarNum(1);
            cm.insert(car);
        }
    }

    //通过购物车物品的名字删除内容
    @GetMapping("user/deletecar")
    public String deletecar(Integer gid){
        System.out.println();
        cm.deleteById(gid);
        System.out.println("================开始删除============");
        String  str="redirect:/user/cart?id="+1;
        return  str;
    }


}
