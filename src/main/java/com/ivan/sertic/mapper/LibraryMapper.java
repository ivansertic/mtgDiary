package com.ivan.sertic.mapper;

import com.ivan.sertic.dto.LibraryDto;
import com.ivan.sertic.model.Library;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LibraryMapper {

    private CardMapper cardMapper;


    public LibraryMapper(){
        this.cardMapper = new CardMapper();
    }

    public LibraryMapper(CardMapper cardMapper){
        this.cardMapper = cardMapper;
    }

    public void update(Library entity, LibraryDto dto){
        entity.setName(dto.getName());
    }

    public LibraryDto toDto(Library entity){
        LibraryDto dto = new LibraryDto();
        dto.setName(entity.getName());
        dto.setExternalLibraryDtoID(entity.getExternalId());
        dto.setId(entity.getId());
        return dto;
    }

    public Library createEntity(LibraryDto dto){
        Library entity = new Library();
        entity.setExternalId(UUID.randomUUID());
        update(entity, dto);
        return entity;
    }
}
