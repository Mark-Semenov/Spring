package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Product;
import ru.geekbrains.DAO.ProductDAO;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product product) {
        productDAO.saveOrUpdate(product);
    }

    public Product getById(Long id) {
        return productDAO.getById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getProducts();
    }

    public void deleteProduct(Long id) {
        productDAO.removeById(id);
    }

}
