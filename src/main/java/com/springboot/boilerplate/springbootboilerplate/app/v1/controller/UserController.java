package com.springboot.boilerplate.springbootboilerplate.app.v1.controller;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateRequestModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateResponseModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.open_api.UserControllerOpenApi;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.UserEntity;
import com.springboot.boilerplate.springbootboilerplate.domain.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements UserControllerOpenApi {

    private final UserMapper mapper;

    public UserController(UserMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserCreateResponseModel> create(@RequestBody UserCreateRequestModel input) {
        UserEntity userEntity = mapper.toUserEntity(input);
        UserCreateResponseModel userCreateResponseModel = mapper.toUserCreateResponseModel(userEntity);
        UserCreateRequestModel userCreateRequestModel = mapper.toUserCreateRequestModel(userEntity);

        return new ResponseEntity<>(userCreateResponseModel, HttpStatus.CREATED);
    }
}
