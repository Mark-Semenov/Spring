package ru.geekbrains.controller;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.entities.Cart;
import ru.geekbrains.entities.Product;
import ru.geekbrains.service.ProductRepository;

import java.util.List;


@RequestMapping("/api/v1/product")
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final Cart cart;

    public ProductRestController(ProductRepository productRepository, Cart cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    @GetMapping("/all")
    public List<Product> findAllProd() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product with id " + id + " not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) throws NotFoundException {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        } else throw new NotFoundException("Product with id " + id + " not found");
    }

    @PostMapping
    public String addProduct(@RequestBody ProductDTO prod) {
        productRepository.save(new Product(prod.getName(), prod.getPrice()));
        return HttpStatus.CREATED.toString();
    }

    @PutMapping
    public String updateProduct(@RequestBody Product prod) {
        productRepository.save(prod);
        return HttpStatus.OK.toString();
    }

    @PostMapping("/cart")
    public String addProdToCart(@RequestBody ProductDTO product){
        cart.addProductToCart(product);
        System.out.println(product.getName());
        System.out.println("Cart size is " + cart.getUserProducts().size());
        cart.getUserProducts().forEach(System.out::println);
        return HttpStatus.OK.toString();
    }

    @DeleteMapping("/cart")
    public String removeProdFromCart(@RequestBody ProductDTO product){
        cart.removeProductFromCart(product.getName());
        System.out.println(product.getName());
        System.out.println(cart.getUserProducts().size());
        cart.getUserProducts().forEach(System.out::println);
        return HttpStatus.OK.toString();
    }


}
