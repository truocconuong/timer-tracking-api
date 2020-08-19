package com.example.demo.service.impl;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.User;
import com.example.demo.service.contract.DTOBuilderService;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DTOBuilderServiceImpl implements DTOBuilderService {
    @Override
    public Map<String, Object> buildProductDto(ProductEntity product) {
        Map<String, Object> result = new HashMap<>();

        result.put("id", product.getId());
        result.put("name", product.getName());
        result.put("price", product.getPrice());


//
//        if (Hibernate.isInitialized(product.getCreatedBy())){
//            result.put("createdBy", buildUserDto(product.getCreatedBy()));
//        }

        return result;
    }

    @Override
    public Map<String, Object> buildUserDto(User user) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", user.getId());
        result.put("username", user.getUsername());
        result.put("email", user.getEmail());
        result.put("name", user.getName());
        return result;
    }
}
