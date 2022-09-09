package com.springboot.boilerplate.springbootboilerplate.app.v1.controller;

import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserCreateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserDetailedResponse;
import com.springboot.boilerplate.springbootboilerplate.app.v1.io.UserUpdateRequest;
import com.springboot.boilerplate.springbootboilerplate.app.v1.open_api.UserControllerOpenApi;
import com.springboot.boilerplate.springbootboilerplate.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(path = "v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements UserControllerOpenApi {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid UserCreateRequest userCreateRequest) {
        userService.create(userCreateRequest);
    }

    @GetMapping
    public ResponseEntity<Page<UserDetailedResponse>> getAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDetailedResponse> getById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDetailedResponse> update(@PathVariable("id") UUID id,
                                                       @RequestBody @Valid UserUpdateRequest userUpdateRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(id, userUpdateRequest));
    }
}
