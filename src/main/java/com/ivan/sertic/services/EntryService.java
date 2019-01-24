package com.ivan.sertic.services;

import com.ivan.sertic.model.Entry;

import java.util.List;
import java.util.UUID;

public interface EntryService {

    Entry getEntryByExternalId(UUID externalEntryId);

    List<Entry> getAllEntries();

    void update(Entry entry);

    void deleteByExternalId(UUID externalEntryId);

    void create(Entry entry);
}
