package com.auth.authserviceforKakebo.entities;

import java.util.UUID;

@Document
//dodac zazlnosci mogodb z maven repository
public class UserEntity {

@Id
    private UUID id;
    private String username;
    private String email;
    private String password;
}
