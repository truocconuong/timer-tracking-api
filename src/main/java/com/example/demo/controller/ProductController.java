package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exceptionhandling.ResourceNotFoundException;
import com.example.demo.service.IProductService;
import com.example.demo.service.contract.DTOBuilderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    DTOBuilderService dtoBuilder;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto<ProductDto>> getProductById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        ProductEntity entity = null;
        try {
            entity = productService.getProductById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("ahiih");
        }
        return ResponseEntity.ok(new ResponseDto<ProductDto>("success", 1, (ProductDto) dtoBuilder.buildProductDto(entity), null));

    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<ResponseDto<ProductDto>> getProductByName(@Param("name") String name) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<ProductEntity> list = null;
        if(name== null) {
            list = productService.getAllProduct();
        } else {
            list = productService.getProductByNames(name);
        }
        List<ProductDto> listDTO = new ArrayList<>();
        for (ProductEntity entity: list) {
            ProductDto productDTO = new ProductDto(entity.getId(),entity.getName(), entity.getPrice(), entity.getQuantity());
            listDTO.add(productDTO);
        }
        return ResponseEntity.ok(new ResponseDto<ProductDto>("success", 1, null, listDTO));
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createProduct(@Valid @RequestBody ProductDto productDTO) {


        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setQuantity(productDTO.getQuantity());

        ProductEntity entity = productService.createProduct(productEntity);
        return ResponseEntity.ok(dtoBuilder.buildProductDto(entity));
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDto dto) {
        ProductEntity productEntity = productService.getProductById(id);
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        productEntity.setQuantity(dto.getQuantity());
        ProductEntity entity = productService.updateProduct(productEntity);

        return ResponseEntity.ok((ProductDto) dtoBuilder.buildProductDto(entity));
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(id);
    }

   private ProductDto convertToDto(ProductEntity product) {
        ProductDto productDto = modelMapper.map(product,ProductDto.class);
        return productDto;
   }

   private ProductEntity convertToEntity(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        return productEntity;
   }
}
