package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
@Data
public class ProductDto {

    private Integer id;
    @NotNull(message = "Name can not be null!!")
    @NotEmpty(message = "Name can not be empty!!")
    private String name;
    @NotNull(message = "Price is required")
    @Max( 00)
    @Min(0)
    private Integer price;
    @NotNull(message = "Quantity can not be null!!")
    private Integer quantity;


    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Integer price, Integer quantity) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
