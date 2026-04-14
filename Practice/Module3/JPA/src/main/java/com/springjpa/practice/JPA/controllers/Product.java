package com.springjpa.practice.JPA.controllers;


import com.springjpa.practice.JPA.entities.ProductEntity;
import com.springjpa.practice.JPA.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/product")
public class Product {

   private  final int PAGE_SIZE=5;
    private final ProductRepository productRepository;

    public  Product(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping(path="/gethealth/{id}")
    public String checkHealth(@PathVariable int id){
        return "I am in good health " + id;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy){
//        return productRepository.findAll();

//        return productRepository.findByCollegeLike("BMS%");
      //  return  productRepository.findByCollegeOrderByPrice("BMS");

//        return  productRepository.findByOrderByPriceDesc();

//        return productRepository.findBy(Sort.by(sortBy));

  // agar dono same rhe toh dono
     return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));



    }
    @GetMapping(path="/pagingbro")
    public Page<ProductEntity> getPage(@RequestParam(defaultValue = "id") String sortBy,
                                       @RequestParam(defaultValue = "0") Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));
        return productRepository.findAll(pageable);
    }

    @GetMapping(path="/another")
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String college,
            @RequestParam(defaultValue = "id") String sortBy ,
            @RequestParam(defaultValue = "0") Integer pageNumber){

        return  productRepository.findByCollegeContainingIgnoreCase(
                college,PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy))
        );




    }



}
