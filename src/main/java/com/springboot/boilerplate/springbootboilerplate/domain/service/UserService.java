package com.springboot.boilerplate.springbootboilerplate.domain.service;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserCreateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserDetailedResponse;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {

    void create(UserCreateRequest userRequest);

    Page<UserDetailedResponse> getAll(Pageable pageable);

    UserDetailedResponse getById(UUID id);

    UserDetailedResponse update(UUID id, UserUpdateRequest userUpdateRequest);
}
