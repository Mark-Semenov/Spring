package ru.geekbrains;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Phone", new BigDecimal(900)));
        products.add(new Product(2L, "Printer", new BigDecimal(1500)));
        products.add(new Product(3L, "Notebook", new BigDecimal(2300)));
        products.add(new Product(4L, "Mouse", new BigDecimal(55)));
        products.add(new Product(5L, "Keyboard", new BigDecimal(76)));
    }


    public List<Product> getProducts() {
        return products;
    }

    public void showProducts() {
        System.out.println("There are next products at the shop");
        for (Product product : products) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
        }
    }

    public Product getProductById(Product product) {
        Product pr = null;
        for (Product p : products) {
            if (p.getId().equals(product.getId())) {
                pr = p;
            }
        }
        return pr;
    }

}
