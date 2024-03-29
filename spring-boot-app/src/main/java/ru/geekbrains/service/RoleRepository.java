package ru.geekbrains.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByTitle(String title);
}
