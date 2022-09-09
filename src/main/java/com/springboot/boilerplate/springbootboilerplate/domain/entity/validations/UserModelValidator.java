package com.springboot.boilerplate.springbootboilerplate.domain.entity.validations;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserCreateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserUpdateRequest;
import com.springboot.boilerplate.springbootboilerplate.domain.repository.UserRepository;
import com.springboot.boilerplate.springbootboilerplate.infrastructure.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserModelValidator {

    private final UserRepository userRepository;

    public void validateForCreate(UserCreateRequest userCreateRequest) {
        validateName(userCreateRequest.getName());
    }

    public void validateForUpdate(UserUpdateRequest userUpdateRequest) {
        validateName(userUpdateRequest.getName());
    }

    private void validateName(String username) {
        userRepository.findByUsername(username).ifPresent(UserEntity -> {
            throw new BusinessException("User already registered with this name");
        });
    }

    private void validateEmail(String email) {
        userRepository.findByEmail(email).ifPresent(professional -> {
            throw new BusinessException("User already registered with this name");
        });
    }
}
