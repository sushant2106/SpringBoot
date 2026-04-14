package com.springjpa.practice.JPA;

import com.springjpa.practice.JPA.entities.ProductEntity;
import com.springjpa.practice.JPA.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsertDb(){
		ProductEntity productEntity=ProductEntity.builder()
				.college("BMS")
				.branch("ECE")
				.price(4005)
				.build();
		ProductEntity saveProductEntity=productRepository.save(productEntity);
		System.out.println(saveProductEntity);

	}




}
