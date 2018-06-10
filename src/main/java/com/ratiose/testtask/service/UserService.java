package com.ratiose.testtask.service;

import java.util.Optional;

import com.ratiose.testtask.dto.RegisterUserDto;
import com.ratiose.testtask.entity.User;

public interface UserService {

    Optional<User> registerUser(RegisterUserDto registerUserDto);
    User findUser(String email, String password);
}

