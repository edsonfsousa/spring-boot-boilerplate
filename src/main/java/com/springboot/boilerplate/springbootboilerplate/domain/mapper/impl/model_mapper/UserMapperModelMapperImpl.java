package com.springboot.boilerplate.springbootboilerplate.domain.mapper.impl.model_mapper;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserCreateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserDetailedResponse;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserUpdateRequest;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.UserEntity;
import com.springboot.boilerplate.springbootboilerplate.domain.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("userMapperModelMapper")
public class UserMapperModelMapperImpl implements UserMapper {

    private final ModelMapper mapper = new ModelMapper();

    public UserMapperModelMapperImpl() {
    }

    @Override
    public UserEntity toUserEntity(UserCreateRequest input) {
        return mapper.map(input, UserEntity.class);
    }

    @Override
    public UserEntity toUpdateUserEntity(UserUpdateRequest input) {
        return mapper.map(input, UserEntity.class);
    }

    @Override
    public UserCreateRequest toUserCreateRequest(UserEntity input) {
        return mapper.map(input, UserCreateRequest.class);
    }

    @Override
    public UserDetailedResponse toUserCreateResponse(UserEntity input) {
        return mapper.map(input, UserDetailedResponse.class);
    }
}
