package ru.geekbrains.entities;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.service.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<Product> userProducts;
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        userProducts = new ArrayList<>();
    }


    public void addProductToCart(ProductDTO product) {
        userProducts.add(productRepository.findByName(product.getName()));
    }

    public void removeProductFromCart(String name) {
        Product product = userProducts.stream().filter(prod -> prod.getName().equals(name)).iterator().next();
        userProducts.remove(product);
    }

    public List<Product> getUserProducts() {
        return userProducts;
    }
}
