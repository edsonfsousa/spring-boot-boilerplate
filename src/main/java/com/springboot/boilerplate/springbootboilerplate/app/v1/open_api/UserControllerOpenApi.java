package com.springboot.boilerplate.springbootboilerplate.app.v1.open_api;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserRequestModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Users Resources")
public interface UserControllerOpenApi {

    @ApiOperation("Users creation resource")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success user creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or user already registered on system")
    })
    void create(UserRequestModel input);
}
