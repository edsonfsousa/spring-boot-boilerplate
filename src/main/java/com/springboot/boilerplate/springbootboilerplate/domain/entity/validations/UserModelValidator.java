package com.springboot.boilerplate.springbootboilerplate.domain.entity.validations;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserRequestModel;
import com.springboot.boilerplate.springbootboilerplate.domain.repository.UserRepository;
import com.springboot.boilerplate.springbootboilerplate.infrastructure.exception.BusinessException;
import org.springframework.stereotype.Component;

@Component
public class UserModelValidator {

    private final UserRepository userRepository;

    public UserModelValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateForCreate(UserRequestModel userRequestModel) {
        validateName(userRequestModel.getName());
    }

    private void validateName(String username) {
        userRepository.findByUsername(username).ifPresent(UserEntity -> {
            throw new BusinessException("User already registered with this name");
        });
    }
}
