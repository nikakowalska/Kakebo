package com.auth.authserviceforKakebo.service;

import com.auth.authserviceforKakebo.dto.CredentialsDto;
import com.auth.authserviceforKakebo.repository.UserCredentialsRepository;
import com.auth.authserviceforKakebo.repository.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserCredentialsRepository userCredentialsRepository;
    public UUID login(CredentialsDto credentialsDto) {
        UserEntity userEntity = userCredentialsRepository.findByEmailAndPassword(credentialsDto.getEmail(), credentialsDto.getPassword());
        return userEntity.getId();
    }
    public UUID addUser(String password, String username, String email){


        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setCreatingTime(Instant.now());
        entity.setVerified(false);

    UserEntity savedEntity = userCredentialsRepository.save(entity);

        return savedEntity.getId();
    }



}
