package com.auth.authserviceforKakebo.entities;

import java.util.UUID;

@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String username;
    private String password;
}
