package ru.geekbrains.DAO;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.Product;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductDAO {

    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        entityManager = factory.createEntityManager();
    }

    public List<Product> getProducts() {
        return entityManager.createNamedQuery("GET_PRODUCTS", Product.class).getResultList();
    }

    public Product getById(Long id) {
        return entityManager.createNamedQuery("GET_BY_ID", Product.class).setParameter("id", id).getSingleResult();
    }
    @Transactional
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
