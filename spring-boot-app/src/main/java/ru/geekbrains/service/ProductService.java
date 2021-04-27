package ru.geekbrains.service;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.entities.Product;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product getProdById(@NonNull Long id) {
        return productRepository.getOne(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void saveOrUpdate(Product product) {
        if (!product.getName().isEmpty() || product.getPrice() != null) {
            productRepository.save(product);
        }
    }

    @Transactional
    public void deleteProd(@NonNull Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> filteringByMinPrice() {
        return productRepository.filteringByMinPrice();
    }

    public List<Product> filteringByMaxPrice() {
        return productRepository.filteringByMaxPrice();
    }

    public List<Product> filteringByMiddlePrice() {
        return productRepository.filteringByMiddlePrice();
    }

}
