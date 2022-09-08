package com.springboot.boilerplate.springbootboilerplate.domain.service.impl;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserRequestModel;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.validations.UserModelValidator;
import com.springboot.boilerplate.springbootboilerplate.domain.mapper.UserMapper;
import com.springboot.boilerplate.springbootboilerplate.domain.repository.UserRepository;
import com.springboot.boilerplate.springbootboilerplate.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserModelValidator userValidator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserModelValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    @Override
    public void create(UserRequestModel userRequestModel) {
        userValidator.validateForCreate(userRequestModel);
        userRepository.save(userMapper.toUserEntity(userRequestModel));
    }

}
