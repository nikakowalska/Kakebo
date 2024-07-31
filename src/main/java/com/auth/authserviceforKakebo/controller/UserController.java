package com.auth.authserviceforKakebo.controller;

import com.auth.authserviceforKakebo.dto.AuthDto;
import com.auth.authserviceforKakebo.dto.CredentialsDto;
import com.auth.authserviceforKakebo.dto.UserUpdateRequest;
import com.auth.authserviceforKakebo.repository.UserCredentialsRepository;
import com.auth.authserviceforKakebo.repository.entities.UserEntity;
import com.auth.authserviceforKakebo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserCredentialsRepository userRepository;
    private UserService userService;

    @PostMapping("/addUser")
    public void addNewUser(
            @RequestHeader("userName") String userName,
            @RequestBody AuthDto authDto
    ) {
        return userService.addUser(userName, authDto);

    }

    @PostMapping("/login")
    public UUID addNewUser(

            @RequestBody CredentialsDto credentialsDto
    ) {
        return userService.login(credentialsDto);
    }

    @GetMapping("/check-verification/{email}")
    public ResponseEntity checkUserVerification(@PathVariable String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if (user.isVerified()) {
            return ResponseEntity.ok("Użytkownik jest zweryfikowany.");
        } else {
            return ResponseEntity.ok("Użytkownik nie jest zweryfikowany.");

        }
    }

    @PutMapping("/update-verification")
    public ResponseEntity updateUserVerification(@RequestBody UserUpdateRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        user.isVerified();
        userRepository.save(user);
        return ResponseEntity.ok("Stan użytkownika zaktualizowany.");
    }
}
