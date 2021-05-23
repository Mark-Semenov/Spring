package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    @Autowired
    private ProductRepository repository;

    private List<Product> cartProducts;
    private boolean isOpen = true;
    private int count = 0;

    @PostConstruct
    public void getCount() {
        cartProducts = new ArrayList<>();
        System.out.println("Cart is open");
        System.out.println(count + " products in the cart");
    }


    public void addProduct(String product) {
        if (isOpen) {
            if (checkProductName(product)) {
                cartProducts.add(getProduct(product));
                count++;
                System.out.println(product + " " + "was added to the cart");
                System.out.println(count + " product(-s) in the cart");
            }
        } else System.out.println("Cart is closed");
    }

    public void deleteProduct(String product) {
        if (isOpen) {
            if (checkProductName(product)) {
                cartProducts.remove(getProduct(product));
                count--;
                System.out.println(product + " " + "was removed from the cart");
                System.out.println(count + " product(-s) in the cart");
            }
        } else System.out.println("Cart is closed");
    }

    public void showProducts() {
        for (Product product : cartProducts) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
        }
        if (cartProducts.isEmpty()){
            System.out.println("Cart is empty");
        }
    }

    public void closeCart() {
        isOpen = false;
        cartProducts.clear();
        count = 0;
        System.out.println("Cart is closed");
    }

    private Product getProduct(String productName) {
        Product product = null;
        for (Product p : repository.getProducts()) {
            if (p.getName().equals(productName)) {
                product = repository.getProductById(p);
            }
        }

        if (productName == null) {
            getMessage();
        }

        return product;
    }

    private boolean checkProductName(String productName) {
        boolean isOk = false;
        for (Product p : repository.getProducts()) {
            if (p.getName().equals(productName)) {
                isOk = true;
                break;
            }
        }

        if (!isOk) {
            System.out.println("Unavailable product. Try again");
        }

        return isOk;
    }


    private void getMessage() {
        System.out.println("There is no such product in the catalog");
    }

    public ProductRepository getRepository() {
        return repository;
    }

}
