package com.auth.authserviceforKakebo.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {

@Id
    private UUID id;
    private String username;
    private String email;
    private String password;
}
