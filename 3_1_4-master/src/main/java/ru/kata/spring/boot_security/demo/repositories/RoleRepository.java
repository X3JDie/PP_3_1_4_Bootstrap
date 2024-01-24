package ru.kata.spring.boot_security.demo.repositories;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;


public interface RoleRepository {

    Set<Role> findByIdRoles(Set<Long> roles);

    Set<Role> getRolesByUserId(Long id);

}
