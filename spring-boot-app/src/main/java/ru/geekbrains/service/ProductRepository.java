package ru.geekbrains.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.geekbrains.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query ("select p from Product p where p.price < (select max (p.price) from Product p) order by p.price")
    List<Product> filteringByMinPrice();

    @Query ("select p from Product p where p.price > (select min (p.price) from Product p) order by p.price desc")
    List<Product> filteringByMaxPrice();

    @Query ("select p from Product p where p.price > (select min (p.price) from Product p)" +
            "and p.price < (select max (p.price) from Product p) " +
            "order by p.price DESC ")
    List<Product> filteringByMiddlePrice();

}
