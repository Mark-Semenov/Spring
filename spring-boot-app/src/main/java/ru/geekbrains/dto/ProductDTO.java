package ru.geekbrains.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ProductDTO {

    private String name;
    private BigDecimal price;
}
