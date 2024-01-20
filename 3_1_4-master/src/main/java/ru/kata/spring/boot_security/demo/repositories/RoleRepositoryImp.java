package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleRepositoryImp implements RoleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> findByIdRoles(Set<Long> roles) {
        TypedQuery<Role> q = entityManager.createQuery("select r from Role r where r.id in :role", Role.class);
        q.setParameter("role", roles);
        return new HashSet<>(q.getResultList());
    }

    @Override
    public Set<Role> getRolesByUserId(Long id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u " +
                "join fetch u.roles where u.id = :id", User.class);
        q.setParameter("id", id);
        return (Set<Role>) q.getResultList().get(0).getRoles();
    }
}
