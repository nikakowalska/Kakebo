package com.auth.authserviceforKakebo.repository;

import com.auth.authserviceforKakebo.repository.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserCredentialsRepository extends MongoRepository<UserEntity, UUID> {
    UserEntity findByEmailAndPassword(String email, String password);

    UserEntity findByEmail(String email);
}
