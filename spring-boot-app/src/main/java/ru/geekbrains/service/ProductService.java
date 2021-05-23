package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return productRepository.filterByMinPrice();
    }

    public List<Product> filteringByMaxPrice() {
        return productRepository.filterByMaxPrice();
    }

    public List<Product> filteringByMiddlePrice() {
        return productRepository.filterByMiddlePrice();
    }

    public Page<Product> pageWithProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

}
