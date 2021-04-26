package ru.geekbrains.DAO;

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

    public Product getById(Long id) {
        return entityManager.createNamedQuery("GET_BY_ID", Product.class).setParameter("id", id).getSingleResult();
    }


    public List<Product> getProductsByUserId(Long id) {
        return entityManager.createNamedQuery("GET_PRODUCTS_BY_USER_ID", Product.class).setParameter("id", id).getResultList();
    }


    public void removeById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getById(id));
        entityManager.getTransaction().commit();
    }

    public void saveOrUpdate(Product product) {
        if (product.getId() != null) {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        } else {
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        }
    }


}
