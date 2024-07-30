package com.auth.authserviceforKakebo.controller;

import com.auth.authserviceforKakebo.dto.EmailDto;
import com.auth.authserviceforKakebo.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authentication")
@AllArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @GetMapping("/validate/{token}")
    public boolean getValidate(@PathVariable String token) {
        return authenticationService.isTokenValid(token);
    }

    @GetMapping(value = "/name/{token}")
    public EmailDto getEmailFromToken(@PathVariable String token) {
        return authenticationService.getEmailFromToken(token);
    }
@RequestBody

//userdto w jsonie

    @PostMapping("{email}/{password}")
    public boolean postUser(

            @PathVariable EmailDto email,
            @PathVariable String password
    ) {
        return authenticationService.createUser(email, password);
    }

}
