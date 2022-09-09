package com.springboot.boilerplate.springbootboilerplate.app.v1.open_api;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserCreateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserDetailedResponse;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Api(tags = "Users Resources")
public interface UserControllerOpenApi {

    @ApiOperation("Users creation resource")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success user creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or user already registered on system")
    })
    void create(UserCreateRequest userCreateRequest);

    @ApiOperation("Users list all resource")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all registered users"),
    })
    ResponseEntity<Page<UserDetailedResponse>> getAll(Pageable pageable);

    @ApiOperation("List User by Id resource")
    ResponseEntity<UserDetailedResponse> getById(UUID id);

    @ApiOperation("Users update resource")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success user update"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or user already registered on system")
    })
    ResponseEntity<UserDetailedResponse> update(UUID id, UserUpdateRequest userUpdateRequest);
}
