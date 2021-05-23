//package ru.geekbrains.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import ru.geekbrains.entities.Product;
//import ru.geekbrains.service.ProductService;
//
//import java.util.List;
//
//@Controller
//public class IndexController {
//
//    private final ProductService productService;
//
//    @Autowired
//    public IndexController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/add")
//    public String index (Model model){
//        Product product = new Product();
//        model.addAttribute("product", product);
//        return "shop";
//    }
//
//    @PostMapping("/add")
//    public String addProduct(Product product){
//        productService.addProduct(product);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/products")
//    public String showProducts(Model model){
//        List<Product> allProd = productService.getAllProducts();
//        model.addAttribute("products", allProd);
//        return "index";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteProducts(@PathVariable(value = "id") Long id){
//        productService.deleteProduct(id);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateProducts(Model model, @PathVariable(value = "id") Long id){
//        model.addAttribute("product", productService.getById(id));
//        return "shop";
//    }
//
//    @PostMapping("/update/{id}")
//    public String update(@PathVariable Long id){
//        productService.addProduct(productService.getById(id));
//        return "redirect:/products";
//    }
//
//    @GetMapping("products/{id}")
//    public String showProducts(Model model, @PathVariable(value = "id") Long id){
//        model.addAttribute("product", productService.getById(id));
//        return "/product";
//    }
//
//}
