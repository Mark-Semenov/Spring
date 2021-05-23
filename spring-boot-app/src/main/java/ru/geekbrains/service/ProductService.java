package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.DAO.ProductDAO;
import ru.geekbrains.DAO.UserDAO;
import ru.geekbrains.entities.Product;
import ru.geekbrains.entities.User;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;
    private final UserDAO userDAO;

    public ProductService(ProductDAO productDAO, UserDAO userDAO) {
        this.productDAO = productDAO;
        this.userDAO = userDAO;
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


    public List<Product> getProductsByUserId(Long id){
        return productDAO.getProductsByUserId(id);
    }

    public List<User> getUsersByProdId(Long id){
        return userDAO.getUsersByProdId(id);
    }

}
