package com.module3.test.jpamodule3.controllers;


import com.module3.test.jpamodule3.entities.ProductEntity;
import com.module3.test.jpamodule3.repositories.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }




}
