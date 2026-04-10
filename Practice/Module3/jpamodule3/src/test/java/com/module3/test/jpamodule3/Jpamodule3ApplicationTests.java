package com.module3.test.jpamodule3;

import com.module3.test.jpamodule3.entities.ProductEntity;
import com.module3.test.jpamodule3.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class Jpamodule3ApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testInsertDb(){
        ProductEntity productEntity=ProductEntity.builder()
                .college("DHINChak")
                .branch("dekhtehai ece")
                .build();
        ProductEntity saveProductEntity=productRepository.save(productEntity);
        System.out.println(saveProductEntity);
    }

    @Test
    void getallProduct(){
        List<ProductEntity>productEntities=productRepository.findAll();
        System.out.println(productEntities);

    }

    @Test
    void getCollegeLike(){
        List<ProductEntity>entities=productRepository.findByCollegeLike("BM%");
        System.out.println(entities);
    }

    @Test
    void getbycollegeandbranch(){
        Optional<ProductEntity> entities=productRepository.findByCollegeAndBranch("BMS","CSE");
        entities.ifPresent(System.out::println);
    }

    @Test
    void getreadFirst2CollegeLike(){
        List<ProductEntity> entity=productRepository.findFirst2ByCollegeLike("BMS%");

        System.out.println(entity);

    }







}
