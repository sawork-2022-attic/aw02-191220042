package com.example.poshell.db;


import com.example.poshell.model.Product;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader {

	@Bean
	InitializingBean init(ProductRepository repository) {
		return () -> {
			repository.save(new Product("PD1", "iPhone 13", 8999));
			repository.save(new Product("PD2", "MacBook Pro", 29499));
		};
	}

}