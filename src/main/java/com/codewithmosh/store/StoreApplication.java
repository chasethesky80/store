package com.codewithmosh.store;

import com.codewithmosh.store.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(StoreApplication.class, args);
		var service = ctx.getBean(UserService.class);
		service.createProdWithCategory();
	}

}
