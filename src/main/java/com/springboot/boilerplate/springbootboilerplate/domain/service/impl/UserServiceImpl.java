package com.springboot.boilerplate.springbootboilerplate.domain.service.impl;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserCreateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserDetailedResponse;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserUpdateRequest;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.UserEntity;
import com.springboot.boilerplate.springbootboilerplate.domain.entity.validations.UserModelValidator;
import com.springboot.boilerplate.springbootboilerplate.domain.mapper.UserMapper;
import com.springboot.boilerplate.springbootboilerplate.domain.repository.UserRepository;
import com.springboot.boilerplate.springbootboilerplate.domain.service.UserService;
import com.springboot.boilerplate.springbootboilerplate.infrastructure.exception.BusinessException;
import com.springboot.boilerplate.springbootboilerplate.infrastructure.exception.IdFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final UserModelValidator userValidator;

    @Override
    public void create(UserCreateRequest userCreateRequest) {
        userValidator.validateForCreate(userCreateRequest);
        userRepository.save(userMapper.toUserEntity(userCreateRequest));
    }

    @Override
    public Page<UserDetailedResponse> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toUserCreateResponse);
    }

    @Override
    public UserDetailedResponse getById(UUID id) {
        return userRepository.findById(id).map(userMapper::toUserCreateResponse).orElseThrow(() -> new IdFoundException(id));
    }

    @Override
    public UserDetailedResponse update(UUID id, UserUpdateRequest userUpdateRequest) {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        Optional<UserEntity> RequestUserName = userRepository.findByUsername(userUpdateRequest.getUsername());

        if (!RequestUserName.equals(foundUser)) {
            if (foundUser.isPresent()) {
                userValidator.validateForUpdate(userUpdateRequest);
            }
        }

        if (foundUser.isEmpty()) {
            throw new BusinessException("User not found");
        }

        UserEntity userToUpdate = userMapper.toUpdateUserEntity(userUpdateRequest);
        userToUpdate.setId(id);
        userRepository.save(userToUpdate);

        return userMapper.toUserCreateResponse(userToUpdate);
    }
}
