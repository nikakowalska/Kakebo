package com.auth.authserviceforKakebo.controller;

import com.auth.authserviceforKakebo.dto.UserDto;
import com.auth.authserviceforKakebo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/auth")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping("/add")
    public UUID addNewUser(
            @RequestHeader ("user-id") String userid,
            @RequestBody UserDto userDto
            ){

    }
}
