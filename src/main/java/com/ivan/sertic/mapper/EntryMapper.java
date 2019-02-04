package com.ivan.sertic.mapper;

import com.ivan.sertic.dto.EntryDto;
import com.ivan.sertic.model.Entry;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class EntryMapper {

    public void update(Entry entity, EntryDto dto){
        entity.setContent(dto.getContentDto());
        entity.setTimeStamp(Instant.now());
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
        entity.setExternalId(UUID.randomUUID());
        update(entity, dto);
        return entity;
    }
}
