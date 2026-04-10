package com.module3.test.jpamodule3.controllers;

import com.module3.test.jpamodule3.entities.ProductEntity;
import com.module3.test.jpamodule3.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {

    private final int PAGE_SIZE=5;

    private final ProductRepository productRepository;


    public  ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

//    @GetMapping
//    public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy , @RequestParam(defaultValue = "1") Integer pageNumber){
//       // return productRepository.findByCollegeOrderByPrice("BMS");
//
////        return  productRepository.findByOrderByPrice();
//
////        return productRepository.findBy(Sort.by(sortBy));
//
//       // return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//
//        //Alternative
//
//        //return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));
//
////        return productRepository.findBy(
////                Sort.by(Sort.Order.desc(sortBy),Sort.Order.asc("price"))
////        );
//
//
//        Pageable pageable= PageRequest.of(pageNumber,PAGE_SIZE);
//
//        return productRepository.findAll(pageable);
//
//
//
//    }

//@GetMapping
//public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy , @RequestParam(defaultValue = "0") Integer pageNumber){
//    // return productRepository.findByCollegeOrderByPrice("BMS");
//
////        return  productRepository.findByOrderByPrice();
//
////        return productRepository.findBy(Sort.by(sortBy));
//
//    // return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
//
//    //Alternative
//
//    //return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));
//
////        return productRepository.findBy(
////                Sort.by(Sort.Order.desc(sortBy),Sort.Order.asc("price"))
////        );
//
//
////    Pageable pageable= PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy));
////
////    return productRepository.findAll(pageable).getContent();
//
//
//
//}

@GetMapping
public List<ProductEntity> getAllProducts(
        @RequestParam(defaultValue = "") String college,
        @RequestParam(defaultValue = "id") String sortBy ,
        @RequestParam(defaultValue = "0") Integer pageNumber){

   return  productRepository.findByCollegeContainingIgnoreCase(
            college,PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy))
    );




}

}
