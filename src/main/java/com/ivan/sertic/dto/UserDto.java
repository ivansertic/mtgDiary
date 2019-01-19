package com.ivan.sertic.dto;

import java.util.UUID;

public class UserDto {
    private Long idDto;

    private UUID externalUserIdDto;

    private String usernameDto;

    private String passwordDto;



    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalUserIdDto() {
        return externalUserIdDto;
    }

    public void setExternalUserIdDto(UUID externalUserIdDto) {
        this.externalUserIdDto = externalUserIdDto;
    }

    public String getUsernameDto() {
        return usernameDto;
    }

    public void setUsernameDto(String usernameDto) {
        this.usernameDto = usernameDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }
}
