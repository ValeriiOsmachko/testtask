package com.ratiose.testtask.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.ratiose.testtask.dto.RegisterUserDto;
import com.ratiose.testtask.entity.Role;
import com.ratiose.testtask.entity.User;
import com.ratiose.testtask.repository.UserRepository;
import com.ratiose.testtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER = "USER";

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Optional<User> registerUser(RegisterUserDto registerUserDto) {
        User user = userRepository.findByEmail(registerUserDto.getEmail());
        if (Objects.isNull(user)) {
            user = createUser(registerUserDto.getEmail(), registerUserDto.getPassword());
            return Optional.ofNullable(userRepository.save(user));
        }
        return Optional.empty();
    }

    @Override
    public User findUser(String email, String password) {
        User foundUser = userRepository.findByEmail(email);
        if (nonNull(foundUser)) {
            if (passwordEncoder.matches(password, foundUser.getPassword())) {
                return foundUser;
            }
        }
        return null;
    }

    private User createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(createDefaultUserRole());
        return user;
    }

    private List<Role> createDefaultUserRole() {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setName(USER);
        roles.add(role);
        return roles;
    }
}