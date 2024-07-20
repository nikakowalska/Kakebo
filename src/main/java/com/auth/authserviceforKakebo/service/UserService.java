package com.auth.authserviceforKakebo.service;

import com.auth.authserviceforKakebo.repository.UserCredentialsRepository;
import com.auth.authserviceforKakebo.repository.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserCredentialsRepository userCredentialsRepository;

    public UUID addUser(String passwordhash, String username, String email){
        //sae to database

        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(passwordhash);

    UserEntity savedEntity = userCredentialsRepository.save(entity);
        System.out.println("User: " + username);
        return savedEntity.getId();
    }
}
