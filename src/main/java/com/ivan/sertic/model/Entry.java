package com.ivan.sertic.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID externalEntryId;

    private String content;

    private Instant timeStamp;

    @ManyToOne
    private Diary diary = new Diary();



    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getExternalId() {
        return externalEntryId;
    }

    public void setExternalId(UUID externalId) {
        this.externalEntryId = externalId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(id, entry.id) &&
                Objects.equals(externalEntryId, entry.externalEntryId) &&
                Objects.equals(content, entry.content) &&
                Objects.equals(timeStamp, entry.timeStamp) &&
                Objects.equals(diary, entry.diary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalEntryId, content, timeStamp, diary);
    }
}
