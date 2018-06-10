package com.ratiose.testtask.controller;

import com.ratiose.testtask.dto.RegisterUserDto;
import com.ratiose.testtask.facade.UserFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/register", method = POST)
    public void registerUser(@RequestBody final RegisterUserDto registerUserDto) {
        userFacade.registerUser(registerUserDto);
    }


}
