package com.springboot.boilerplate.springbootboilerplate.domain.mapper;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserRequestModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserResponseModel;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.UserEntity;

public interface UserMapper {
    
    UserEntity toUserEntity(UserRequestModel input);

    UserRequestModel toUserCreateRequestModel(UserEntity input);

    UserResponseModel toUserCreateResponseModel(UserEntity input);
}
