package com.auth.authserviceforKakebo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenExpiration {
    private final long expirationTime = 3600000; //1h;
private LocalDateTime tokenCreationTime;


    public boolean isExpired(LocalDateTime tokenCreationTime) {
     LocalDateTime tokenTimeMillis = getTokenCreationTime().plusSeconds(expirationTime);

        return Instant.now().isAfter(Instant.from(tokenTimeMillis))  ;
    }
}