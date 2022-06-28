package com.wink.controller;

import com.wink.domain.Category;
import com.wink.domain.Goods;
import com.wink.mapper.CategoryMapper;
import com.wink.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService gs;
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

        //List<Goods>  goods=gs.selectAll();
        //session.setAttribute("goods",goods);
       return "index";
    }


}
