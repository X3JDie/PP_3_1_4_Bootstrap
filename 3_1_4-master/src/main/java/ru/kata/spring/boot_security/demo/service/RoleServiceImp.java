package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findByIdRoles(Set<Long> roles) {
        return new HashSet<>(roleRepository.findByIdRoles(roles));
    }

    @Override
    public Set<Role> getRolesByUserId(Long id) {
        return new HashSet<>(roleRepository.getRolesByUserId(id));
    }

}
