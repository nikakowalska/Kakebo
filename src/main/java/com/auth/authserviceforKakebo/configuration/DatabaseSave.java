package com.auth.authserviceforKakebo.configuration;

import com.auth.authserviceforKakebo.repository.UserCredentialsRepository;
import com.auth.authserviceforKakebo.repository.entities.UserEntity;
import com.auth.authserviceforKakebo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

@Component
@AllArgsConstructor

public class DatabaseSave implements ApplicationListener<ContextRefreshedEvent> {

    private final UserCredentialsRepository userCredentialsRepository;
    private UserService userService;

    private void initUser() {
        int countUsers = userCredentialsRepository.findAll().size();
        if (countUsers == 0) {
            UserEntity userEntity = saveUserToDatabase("hashPassworfromMongo");
            userCredentialsRepository.save(userEntity);
        }
    }

    private UserEntity saveUserToDatabase(String pw) {
        String password = hashToPassword(pw);

        return UserEntity.builder()
                .id(UUID.randomUUID())
                .username("admin")
                .email("email")
                .password(password)
                .creatingTime(Instant.now())
                .isVerified(false).build();
    }

    private String hashToPassword(String pw) {
        byte[] afterDecode = Base64.getDecoder().decode(pw);
        return new String(afterDecode, StandardCharsets.UTF_8);
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        System.out.println("Create admin account");
        initUser();
    }
}
