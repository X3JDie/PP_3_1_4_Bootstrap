package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

@Component
public interface RoleRepository {

    Set<Role> findByIdRoles(Set<Long> roles);

    Set<Role> getRolesByUserId(Long id);

}
