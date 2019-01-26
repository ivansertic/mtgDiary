package com.ivan.sertic.dto;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DiaryDto {

    private Long idDto;

    private UUID externalDiaryIdDto;

    @NotNull
    private String nameDto;

    private UserDto userDto;

    private Set<EntryDto> entryDtoSet = new HashSet<>();

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalDiaryIdDto() {
        return externalDiaryIdDto;
    }

    public void setExternalDiaryIdDto(UUID externalDiaryIdDto) {
        this.externalDiaryIdDto = externalDiaryIdDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Set<EntryDto> getEntryDtoSet() {
        return entryDtoSet;
    }

    public void setEntryDtoSet(Set<EntryDto> entryDtoSet) {
        this.entryDtoSet = entryDtoSet;
    }
}
