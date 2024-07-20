package com.auth.authserviceforKakebo.service;

import com.auth.authserviceforKakebo.builder.TokenBuilder;
import com.auth.authserviceforKakebo.dto.AuthDto;
import com.auth.authserviceforKakebo.dto.EmailDto;
import com.auth.authserviceforKakebo.dto.UserDto;
import com.auth.authserviceforKakebo.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
@Service
public class AuthenticationService {

    private static final long TOKEN_TIME_AVAIBILITY = 600;
    private Map<EmailDto, String> userData = new HashMap<>() {
    };

    public AuthDto getAuthToken(UserDto userDto) {

        String newToken = TokenBuilder.builder("_")
                .withId(userDto.getId().toString())
                .withUserName(userDto.getUsername())
                .withEmail(userDto.getEmail())
                .withActiveTokenTime(TOKEN_TIME_AVAIBILITY)
                .build();

        String token = Base64.getEncoder().withoutPadding().encodeToString(newToken.getBytes());

        return new AuthDto(token);
    }

    public boolean isTokenValid(String token) {
        byte[] userDataByte = Base64.getDecoder().decode(token.getBytes());
        String[] userDataRows = new String(userDataByte).split("_");
        String[] userDataEmail = userDataRows[1].split("=");
        String[] userDataTime = userDataRows[2].split("=");

        if (!userData.containsKey((String) userDataEmail[1])) {
            throw new ValidationException("Invalid token");
        }
        Instant date = Instant.parse(userDataTime[1]);
        if (Instant.now().isAfter(date)) {
            throw new ValidationException("Token Expired");
        }
        return true;
    }

    public EmailDto getEmailFromToken(String token) {
        byte[] userDataByte = Base64.getDecoder().decode(token.getBytes());
        String[] userDataRows = new String(userDataByte).split("_");
        String[] userDataEmail = userDataRows[0].split("=");
        if (!userData.containsKey(userDataEmail[2])) {
            throw new ValidationException("Invalid token");
        }

        return new EmailDto(userDataEmail[2]);
    }

    public boolean createUser(EmailDto emailDto, String password) {

        userData.put(emailDto, password);
        return true;
    }
}
