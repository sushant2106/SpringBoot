package com.module3.test.jpamodule3.repositories;

import com.module3.test.jpamodule3.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

     List<ProductEntity>findByCollegeLike(String college);
     Optional<ProductEntity> findByCollegeAndBranch(String college, String branch);

     List<ProductEntity>findFirst2ByCollegeLike(String college);
    List<ProductEntity> findByCollegeOrderByPrice(String college);

    List<ProductEntity>findByOrderByPrice();

    List<ProductEntity>findBy(Sort sort);

    List<ProductEntity>findByCollegeContainingIgnoreCase(String college, Pageable pageable);

}
