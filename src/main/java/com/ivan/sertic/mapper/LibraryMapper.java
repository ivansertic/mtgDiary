package com.ivan.sertic.mapper;

import com.ivan.sertic.dto.LibraryDto;
import com.ivan.sertic.model.Library;

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
        return dto;
    }

    public Library createEntity(LibraryDto dto){
        Library entity = new Library();
        update(entity, dto);
        return entity;
    }
}
