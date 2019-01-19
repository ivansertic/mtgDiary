package com.ivan.sertic.mapper;

import com.ivan.sertic.dto.DiaryDto;
import com.ivan.sertic.model.Diary;

public class DiaryMapper {

    private EntryMapper entryMapper;

    public DiaryMapper(){
        this.entryMapper = new EntryMapper();
    }

    public DiaryMapper(EntryMapper entryMapper){
        this.entryMapper = entryMapper;
    }

    public void update(Diary entity, DiaryDto dto){
        entity.setName(dto.getNameDto());
    }

    public DiaryDto toDto(Diary entity){
        DiaryDto dto = new DiaryDto();
        dto.setNameDto(entity.getName());
        dto.setExternalDiaryIdDto(entity.getExternalId());
        dto.setIdDto(entity.getId());
        return dto;
    }

    public Diary createEntity(DiaryDto dto){
        Diary entity = new Diary();
        update(entity,dto);
        return entity;
    }
}
