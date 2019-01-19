package com.ivan.sertic.dto;

import java.time.Instant;
import java.util.UUID;

public class EntryDto {

    private Long idDto;

    private UUID externalEntryIdDto;

    private String contentDto;

    private Instant timestampDto;

    private DiaryDto diaryDto;



    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public UUID getExternalEntryIdDto() {
        return externalEntryIdDto;
    }

    public void setExternalEntryIdDto(UUID externalEntryIdDto) {
        this.externalEntryIdDto = externalEntryIdDto;
    }

    public String getContentDto() {
        return contentDto;
    }

    public void setContentDto(String contentDto) {
        this.contentDto = contentDto;
    }

    public Instant getTimestampDto() {
        return timestampDto;
    }

    public void setTimestampDto(Instant timestampDto) {
        this.timestampDto = timestampDto;
    }

    public DiaryDto getDiaryDto() {
        return diaryDto;
    }

    public void setDiaryDto(DiaryDto diaryDto) {
        this.diaryDto = diaryDto;
    }
}
