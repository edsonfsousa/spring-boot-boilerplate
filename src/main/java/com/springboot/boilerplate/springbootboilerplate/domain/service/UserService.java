package com.springboot.boilerplate.springbootboilerplate.domain.service;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserRequestModel;

public interface UserService {

    void create(UserRequestModel userRequest);
}
