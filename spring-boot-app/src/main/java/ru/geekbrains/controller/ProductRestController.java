package ru.geekbrains.controller;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.entities.Product;
import ru.geekbrains.service.ProductRepository;

import java.util.List;


@RequestMapping("/api/v1/product")
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
    public String addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return HttpStatus.CREATED.toString();
    }

    @PutMapping
    public String updateProduct(@RequestBody Product product) {
        productRepository.save(product);
        return HttpStatus.OK.toString();
    }


}
