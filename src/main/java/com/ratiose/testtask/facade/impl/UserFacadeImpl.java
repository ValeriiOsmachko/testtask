package com.ratiose.testtask.facade.impl;

import java.util.Objects;
import java.util.Optional;

import com.ratiose.testtask.dto.RegisterUserDto;
import com.ratiose.testtask.entity.User;
import com.ratiose.testtask.exception.InvalidRegisterDataException;
import com.ratiose.testtask.exception.UserAlreadyExistsException;
import com.ratiose.testtask.exceptiondataenum.ExceptionData;
import com.ratiose.testtask.facade.UserFacade;
import com.ratiose.testtask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public void registerUser(final RegisterUserDto userDto) {
        checkRegisterData(userDto);
        Optional<User> user = userService.registerUser(userDto);
        if(!user.isPresent()) {
            throw new UserAlreadyExistsException(ExceptionData.USER_ALREADY_EXISTS);
        }
    }

    private void checkRegisterData(final RegisterUserDto userDto) {
        if(Objects.isNull(userDto.getEmail()) || Objects.isNull(userDto.getPassword()) || Objects.isNull(userDto.getUserName())) {
            throw new InvalidRegisterDataException(ExceptionData.INVALID_REGISTER_DATA);
        }
    }
}
