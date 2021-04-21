package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final AtomicLong atomicLong = new AtomicLong(3);


    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        product.setId(atomicLong.incrementAndGet());
        repository.getProducts().add(product);
    }

    public Product getById(Long id) {
        Product product = null;
        for (Product p: repository.getProducts()) {
            if (p.getId().equals(id)){
                product = p;
            }
        }
        return product;
    }

    public List<Product> getAllProducts() {
        return repository.getProducts();
    }

    public void deleteProduct(Long id) {
        repository.removeById(id);
    }

}
