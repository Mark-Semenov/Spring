package ru.geekbrains.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query ("select p from Product p where p.price < (select max (p.price) from Product p) order by p.price")
    List<Product> filterByMinPrice();

    @Query ("select p from Product p where p.price > (select min (p.price) from Product p) order by p.price desc")
    List<Product> filterByMaxPrice();

    @Query ("select p from Product p where p.price > (select min (p.price) from Product p)" +
            "and p.price < (select max (p.price) from Product p) " +
            "order by p.price DESC ")
    List<Product> filterByMiddlePrice();

    Page<Product> findAll(Pageable pageable);

    Product findByName(String productName);

}
