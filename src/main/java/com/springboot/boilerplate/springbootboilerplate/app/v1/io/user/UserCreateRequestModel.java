package com.springboot.boilerplate.springbootboilerplate.app.v1.io.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestModel {

    @NotBlank
    @Size(min = 3, max = 20)
    @Column(name = "username", nullable = false, length = 20, unique = true)
    private String username;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
}
