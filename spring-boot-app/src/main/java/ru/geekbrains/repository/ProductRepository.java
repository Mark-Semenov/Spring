package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init (){
        products = new ArrayList<>();
        products.add(new Product(1L, "Phone", new BigDecimal(1000)));
        products.add(new Product(2L, "Printer", new BigDecimal(1500)));
        products.add(new Product(3L, "Notebook", new BigDecimal(2000)));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void removeById(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }
}
