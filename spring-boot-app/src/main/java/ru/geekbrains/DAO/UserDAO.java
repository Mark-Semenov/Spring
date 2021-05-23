package ru.geekbrains.DAO;

import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAO {

    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getUsersByProdId(Long id) {
        return entityManager.createNamedQuery("GET_USERS_BY_PROD_ID", User.class).setParameter("id", id).getResultList();
    }

}
