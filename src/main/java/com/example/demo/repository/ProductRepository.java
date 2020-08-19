package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query("select c from ProductEntity c where c.name like %:name%")
    List<ProductEntity> findByNames(@Param("name") String name);
    // select * from product where name = name
    List<ProductEntity> findByName(String name);
    
}
