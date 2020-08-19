package com.example.demo.service.contract;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.User;

import java.util.Map;

public interface DTOBuilderService {
    public Map<String, Object> buildProductDto(ProductEntity product);
    public Map<String, Object> buildUserDto(User product);
}
