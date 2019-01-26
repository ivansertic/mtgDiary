package com.ivan.sertic.mapper;

import com.ivan.sertic.dto.EntryDto;
import com.ivan.sertic.model.Entry;
import org.springframework.stereotype.Component;

@Component
public class EntryMapper {

    public void update(Entry entity, EntryDto dto){
        entity.setContent(dto.getContentDto());
        entity.setTimeStamp(dto.getTimestampDto());
    }

    public EntryDto toDto(Entry entity){
        EntryDto dto = new EntryDto();
        dto.setContentDto(entity.getContent());
        dto.setTimestampDto(entity.getTimeStamp());
        dto.setExternalEntryIdDto(entity.getExternalId());
        dto.setIdDto(entity.getId());
        return dto;
    }

    public Entry createEntity(EntryDto dto){
        Entry entity = new Entry();
        update(entity, dto);
        return entity;
    }
}
