package ru.geekbrains.dto;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDTO {

    private String name;
    private BigDecimal price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
