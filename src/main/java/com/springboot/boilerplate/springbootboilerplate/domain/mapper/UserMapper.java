package com.springboot.boilerplate.springbootboilerplate.domain.mapper;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserCreateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserDetailedResponse;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserUpdateRequest;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.UserEntity;

public interface UserMapper {

    UserEntity toUserEntity(UserCreateRequest input);

    UserEntity toUpdateUserEntity(UserUpdateRequest input);

    UserCreateRequest toUserCreateRequest(UserEntity input);

    UserDetailedResponse toUserCreateResponse(UserEntity input);
}
