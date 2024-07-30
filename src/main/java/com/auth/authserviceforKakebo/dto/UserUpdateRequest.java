package com.auth.authserviceforKakebo.dto;

import com.auth.authserviceforKakebo.repository.entities.UserEntity;

public class UserUpdateRequest {
    private UserEntity user;
    public String getEmail(UserEntity user) {
    return user.getEmail();
    }

    public boolean isVerified() {
    return true;
    }
}
