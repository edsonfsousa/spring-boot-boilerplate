package com.springboot.boilerplate.springbootboilerplate.domain.mapper.impl.model_mapper;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserRequestModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserResponseModel;
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
    public UserEntity toUserEntity(UserRequestModel input) {
        return mapper.map(input, UserEntity.class);
    }

    @Override
    public UserRequestModel toUserCreateRequestModel(UserEntity input) {
        return mapper.map(input, UserRequestModel.class);
    }

    @Override
    public UserResponseModel toUserCreateResponseModel(UserEntity input) {
        return mapper.map(input, UserResponseModel.class);
    }
}
