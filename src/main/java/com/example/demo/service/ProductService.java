package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity getProductById(Integer id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> getProductByNames(String name) {
        return productRepository.findByNames(name);
    }

    @Override
    public ProductEntity createProduct(ProductEntity entity) {
        return productRepository.save(entity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity entity) {
         return productRepository.save(entity);
    }

    @Override
    public Integer deleteProduct(int id) {
        productRepository.deleteById(id);
        return id;
    }

}
