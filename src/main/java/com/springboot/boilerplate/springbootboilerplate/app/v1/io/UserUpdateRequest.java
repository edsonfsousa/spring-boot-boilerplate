package com.springboot.boilerplate.springbootboilerplate.app.v1.io;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(nullable = false, length = 20, unique = true)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @NotBlank
    @Size(min = 3, max = 30)
    private String city;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    @Size(min = 3, max = 40)
    private String address;

    @Valid
    private UserUpdateRequest userUpdateRequest;
}
