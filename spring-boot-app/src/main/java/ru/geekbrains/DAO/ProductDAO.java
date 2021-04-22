package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.Product;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDAO {


    private final EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getProducts() {
       return entityManager.createNamedQuery("GET_PRODUCTS", Product.class).getResultList();
    }

    public Product getById(Long id){
        return entityManager.createNamedQuery("GET_BY_ID", Product.class).setParameter("id", id).getSingleResult();
    }

    public void removeById(Long id){
        entityManager.remove(getById(id));
    }

    public void saveOrUpdate(Product product){
        entityManager.persist(product);
    }
}
