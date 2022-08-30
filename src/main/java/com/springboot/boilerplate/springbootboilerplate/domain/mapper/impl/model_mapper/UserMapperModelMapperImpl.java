package com.springboot.boilerplate.springbootboilerplate.domain.mapper.impl.model_mapper;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateRequestModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateResponseModel;
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
    public UserEntity toUserEntity(UserCreateRequestModel input) {
        return mapper.map(input, UserEntity.class);
    }

    @Override
    public UserCreateRequestModel toUserCreateRequestModel(UserEntity input) {
        return mapper.map(input, UserCreateRequestModel.class);
    }

    @Override
    public UserCreateResponseModel toUserCreateResponseModel(UserEntity input) {
        return mapper.map(input, UserCreateResponseModel.class);
    }
}
