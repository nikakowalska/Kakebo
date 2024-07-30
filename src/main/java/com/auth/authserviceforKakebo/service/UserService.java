package com.auth.authserviceforKakebo.service;

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

    public UUID addUser(String passwordhash, String username, String email){
        //sae to database

        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(passwordhash);
        entity.setCreatingTime(Instant.now());
        entity.setVerified(false);

    UserEntity savedEntity = userCredentialsRepository.save(entity);

        return savedEntity.getId();
    }
    //stworz klase konfiguracyjna @Component, wczytuje sie swoje ustawienia z plkików konfiguracyjnych
    //kazde srodowisko ma swoje pliki konfiguracyjne
    //maja info jaki adres z jaka bazą danych
    //warto wyciagnac czas waznosci tokena z klasy

}
