package com.springjpa.practice.JPA.repositories;

import com.springjpa.practice.JPA.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity>findByCollegeLike(String college);
    List<ProductEntity>findByCollegeOrderByPrice(String college);

    List<ProductEntity>findByOrderByPriceDesc();

    List<ProductEntity>findBy(Sort sort);

    List<ProductEntity>findByCollegeContainingIgnoreCase(String college, Pageable pageable);
}
