package com.jpatutorial.jpa_test.repositories;

import com.jpatutorial.jpa_test.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);
    List<ProductEntity>findByCreatedAtAfter(LocalDateTime after);
    List<ProductEntity>findByQuantityAndPrice(int qty, BigDecimal price);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int qty,BigDecimal price);
    List<ProductEntity>findByQuantityGreaterThanOrPriceLessThan(int qty,BigDecimal price);


    List<ProductEntity>findByTitleLike(String title);

    List<ProductEntity>findByTitleContaining(String title);

    List<ProductEntity>findByTitleContainingIgnoreCase(String title);

//    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

   //e.title
    //    @Query("select e from ProductEntity e where e.title=:title and e.price=:price")
    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2")
    Optional<ProductEntity>findByTitleAndPrice(String title, BigDecimal price);

}


