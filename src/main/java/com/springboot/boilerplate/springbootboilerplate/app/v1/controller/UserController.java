package com.springboot.boilerplate.springbootboilerplate.app.v1.controller;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserRequestModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.open_api.UserControllerOpenApi;
import com.springboot.boilerplate.springbootboilerplate.domain.mapper.UserMapper;
import com.springboot.boilerplate.springbootboilerplate.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements UserControllerOpenApi {

    private final UserService userService;

    private final UserMapper usermapper;

    public UserController(UserMapper usermapper, UserService userService) {
        this.usermapper = usermapper;
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid UserRequestModel userRequestModel) {
        userService.create(userRequestModel);
    }
}
