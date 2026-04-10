package com.jpatutorial.jpa_test;

import com.jpatutorial.jpa_test.entities.ProductEntity;
import com.jpatutorial.jpa_test.repositories.ProductRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTestApplicationTests {


  @Autowired
  ProductRepository productRepository;




	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity productEntity=ProductEntity.builder()
                .sku("nestlePepsi")
                .title("NestlePespiChocolate")
                .price(BigDecimal.valueOf(12283.4588))
                .quantity(773)
                .build();
        ProductEntity saveProductEntity=productRepository.save(productEntity);
        System.out.println(saveProductEntity);
    }

    @Test
    void getRepository(){
        List<ProductEntity> entities=productRepository.findAll();
        System.out.println(entities);
    }

    @Test
    void getTitlePresent(){
        List<ProductEntity> entities=productRepository.findByTitle("Pepsi");
        List<ProductEntity> afterentities=productRepository.findByCreatedAtAfter(LocalDateTime.of(2026,1,1,0,0,0));
        System.out.println(entities);
    }

    @Test
    void getCompare2(){
        List<ProductEntity> entities=productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(23.45));
        System.out.println(entities);
    }

    @Test
    void   getTitlelike(){

        List<ProductEntity>entities=productRepository.findByTitleLike("%Choco%");

        List<ProductEntity>entities1=productRepository.findByTitleContaining("Choco");

        List<ProductEntity>entities2=productRepository.findByTitleContainingIgnoreCase("Choco");
        System.out.println(entities);
        System.out.println(entities1);
        System.out.println(entities2);

    }


    @Test
    void getSingleFromRepository(){
        Optional<ProductEntity>productEntity=productRepository.findByTitleAndPrice("Nestle Chocolate",BigDecimal.valueOf(23.45));
        productEntity.ifPresent(System.out::println);
    }










}
