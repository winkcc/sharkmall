package com.wink.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//相当于springMVC的配置文件

@Configuration
public class WebConfig implements WebMvcConfigurer{

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//配置无业务逻辑的路径与视图的映射
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/user/login").setViewName("user/login");
		registry.addViewController("/user/reg").setViewName("user/reg");
		registry.addViewController("/goods").setViewName("goods");
		registry.addViewController("/user/cart").setViewName("user/cart");

	}

}
