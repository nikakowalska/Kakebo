package com.auth.authserviceforKakebo.mapperrs;


import com.auth.authserviceforKakebo.dto.UserDto;
import com.auth.authserviceforKakebo.entities.UserEntity;

public class UserMapper {
    public UserEntity fromDtoToEntity(UserDto userDto) {
        var entity = new UserEntity();
entity.setId(userDto.getId());
//        entity.setPassword(userDto.getPassword());
//        entity.setUsername(userDto.getUsername());
//        entity.setEmail(userDto.getEmail());

        return entity;
    }
}
