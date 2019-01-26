package com.ivan.sertic.mapper;


import com.ivan.sertic.dto.UserDto;
import com.ivan.sertic.model.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public void update(Users entity, UserDto dto){
        entity.setUsername(dto.getUsernameDto());
        entity.setPassword(dto.getPasswordDto());
    }

    public UserDto toDto(Users entity){
        UserDto dto = new UserDto();
        dto.setPasswordDto(entity.getPassword());
        dto.setUsernameDto(entity.getUsername());
        dto.setExternalUserIdDto(entity.getExternalId());
        dto.setIdDto(entity.getId());
        return dto;
    }

    public Users createEntity(UserDto dto){
        Users entity = new Users();
        update(entity, dto);
        return entity;
    }


}
