package com.springboot.boilerplate.springbootboilerplate.app.v1.open_api;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateRequestModel;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.user.UserCreateResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api("User module management")
public interface UserControllerOpenApi {

    @ApiOperation("User creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success user creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or user already registered on system")
    })
    ResponseEntity<UserCreateResponseModel> create(UserCreateRequestModel input);
}
