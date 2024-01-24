package ru.kata.spring.boot_security.demo.repositories;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;


public interface UserRepository {

    Set<User> getAllUsers();

    User getUserById(Long id);

    void delete(Long id);

    User getUserByName(String name);

    void addRole(Role role);

    void save(User user);

    public Role findById(Long id);

    User getUserByLogin(String name);

    public void updateUser(User user);

    public void createUser(User user);

}
