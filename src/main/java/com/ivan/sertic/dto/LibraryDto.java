package com.ivan.sertic.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LibraryDto {

    private Long idDto;

    private UUID externalLibraryDtoID;

    private String name;

    private UserDto user;

    private Set<CardDto> cardDtoSet = new HashSet<>();



    public Long getId() {
        return idDto;
    }

    public void setId(Long id) {
        this.idDto = idDto;
    }

    public UUID getExternalLibraryDtoID() {
        return externalLibraryDtoID;
    }

    public void setExternalLibraryDtoID(UUID externalLibraryDtoID) {
        this.externalLibraryDtoID = externalLibraryDtoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Set<CardDto> getCardDtoSet() {
        return cardDtoSet;
    }

    public void setCardDtoSet(Set<CardDto> cardDtoSet) {
        this.cardDtoSet = cardDtoSet;
    }
}
