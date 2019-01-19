package com.ivan.sertic.mapper;


import com.ivan.sertic.dto.UserDto;
import com.ivan.sertic.model.User;

public class UserMapper {

    public void update(User entity, UserDto dto){
        entity.setUsername(dto.getUsernameDto());
        entity.setPassword(dto.getPasswordDto());
    }

    public UserDto toDto(User entity){
        UserDto dto = new UserDto();
        dto.setPasswordDto(entity.getPassword());
        dto.setUsernameDto(entity.getUsername());
        return dto;
    }

    public User createEntity(UserDto dto){
        User entity = new User();
        update(entity, dto);
        return entity;
    }


}
