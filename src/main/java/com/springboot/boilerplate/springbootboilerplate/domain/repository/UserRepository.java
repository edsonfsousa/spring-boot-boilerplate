package com.springboot.boilerplate.springbootboilerplate.domain.repository;

import com.springboot.boilerplate.springbootboilerplate.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String name);
}
