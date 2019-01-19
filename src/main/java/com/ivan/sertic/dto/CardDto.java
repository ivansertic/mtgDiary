package com.ivan.sertic.dto;

import java.util.UUID;

public class CardDto {
    private Long idDto;

    private UUID externalCardDtoId;

    private String name;

    private String manaCost;

    private String description;

    private String edition;

    private LibraryDto library;



    public LibraryDto getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDto library) {
        this.library = library;
    }

    public Long getId() {
        return idDto;
    }

    public void setId(Long id) {
        this.idDto = id;
    }

    public UUID getExternalCardId() {
        return externalCardDtoId;
    }

    public void setExternalCardId(UUID externalCardId) {
        this.externalCardDtoId = externalCardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
}
