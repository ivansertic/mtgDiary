package com.ivan.sertic.services;

import com.ivan.sertic.model.Entry;

import java.util.List;
import java.util.UUID;

public interface EntryService {

    Entry getEntryByExternalId(UUID externalEntryId);

    Entry getSingleEntry(UUID externalDiaryId, UUID externalUserId, UUID externalEntryId);

    List<Entry> getAllEntries(UUID externalDiaryId);

    void update(UUID externalEntryId,Entry entry);

    void deleteByExternalId(UUID externalDiaryId);

    void create(Entry entry);
}
