package com.auth.authserviceforKakebo.service;

import com.auth.authserviceforKakebo.builder.TokenBuilder;
import com.auth.authserviceforKakebo.dto.AuthDto;
import com.auth.authserviceforKakebo.dto.UserDto;

import java.util.Base64;

public class AuthenticationService {
    private static final long TOKEN_TIME_AVAIBILITY = 600;
    public AuthDto getAuthToken(UserDto userDto) {

        String newToken = TokenBuilder.builder("_")
                .withId(userDto.getId().toString())
                .withUserName(userDto.getUsername())
                .withActiveTokenTime(TOKEN_TIME_AVAIBILITY)
                .build();

        String token = Base64.getEncoder().withoutPadding().encodeToString(newToken.getBytes());

        return new AuthDto(token);
    }
}
