package com.example.demo.service;

import com.example.demo.entity.ProductEntity;

import java.util.List;


public interface IProductService {
    ProductEntity getProductById(Integer id);
    List<ProductEntity> getAllProduct();
    List<ProductEntity> getProductByNames(String name);
    ProductEntity createProduct(ProductEntity entity);
    ProductEntity updateProduct(ProductEntity entity);
    Integer deleteProduct(int id);
}
