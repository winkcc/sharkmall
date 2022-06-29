package com.wink.controller;

import com.wink.domain.Category;
import com.wink.domain.Goods;
import com.wink.mapper.CategoryMapper;
import com.wink.mapper.GoodsMapper;
import com.wink.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService gs;
    @Autowired
    private GoodsMapper gm;
    @Autowired
    private CategoryMapper cm;

    @RequestMapping("/")
    public String selecrAll(HttpSession session){
        //所有商品类型: 2 香烟
        List<Category> categories=cm.selectList(null);
        session.setAttribute("categories",categories);
        //放到session中
        for (Category type:categories) {
            session.setAttribute("t"+type.getCategoryId(),type.getCategoryName());
            session.setAttribute("type"+type.getCategoryId(),gs.selectTypeAll(type.getCategoryId()));
        }
       return "index";
    }


    @RequestMapping("/showgoods")
    public String showGoods(Integer id, HttpSession session){
        Goods goods = gs.selectById(id);
        System.out.println(goods);
        session.setAttribute("goods",goods);
        return "goods";
    }

    @PostMapping("/search")
    public String searchgoods(Goods goods,HttpSession session){
        List<Goods> goods1=gm.selectAllbyname(goods.getGoodsName());
        for (Goods gd:goods1
             ) {
            System.out.println(gd);
        }
        session.setAttribute("searchg",goods1);
        return "search";
    }


    @GetMapping("/search")
    public String jumpsearch(HttpSession session){

        return "search";
    }


}
