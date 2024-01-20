package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Set<User> getAllUsers() {
        return new HashSet<>(userRepository.getAllUsers());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    public Collection<? extends GrantedAuthority> grantedAuthorities(Collection<Role> roles) {
        return roles.stream().map(el -> new SimpleGrantedAuthority(el.getName())).collect(Collectors.toList());
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public void updateUser(User user) {
        if (user.getId() == null) {
            userRepository.updateUser(passwordCoder(user));
        } else {
            userRepository.updateUser(user);
        }
    }

    @Override
    public User getUserByLogin(String name) {
        return userRepository.getUserByLogin(name);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Role findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addRole(Role role) {
        userRepository.addRole(role);
    }
}
