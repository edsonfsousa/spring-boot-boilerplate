package com.springboot.boilerplate.springbootboilerplate.app.v1.io;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModel {

    private UUID id;

    private String name;

    private String username;

    private String password;

    private String city;

    private String address;
}
