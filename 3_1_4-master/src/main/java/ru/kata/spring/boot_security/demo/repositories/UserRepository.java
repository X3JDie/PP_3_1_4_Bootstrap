package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Component
public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(Long id);
    void delete (Long id);

    User getUserByName(String name);

    void addRole (Role role);

    void save (User user);

    public Role findById(Long id);

    User getUserByLogin(String name);

    public void updateUser (User user);

}
