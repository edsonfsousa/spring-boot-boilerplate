package com.springboot.boilerplate.springbootboilerplate.domain.mapper;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateRequestModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateResponseModel;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.UserEntity;

public interface UserMapper {
    UserEntity toUserEntity(UserCreateRequestModel input);

    UserCreateRequestModel toUserCreateRequestModel(UserEntity input);

    UserCreateResponseModel toUserCreateResponseModel(UserEntity input);
}
