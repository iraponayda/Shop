package ua.com.shop.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.shop.entity.Toy;
import ua.com.shop.service.ToyService;
import ua.com.shop.serviceImpl.ToyServiceImpl;

public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/appContext.xml");
		
		ToyService toyService = (ToyService) context.getBean(ToyServiceImpl.class);
		toyService.save(new Toy());
		context.close();
	}

}
