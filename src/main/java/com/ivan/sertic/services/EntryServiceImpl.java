package com.ivan.sertic.services;

import com.ivan.sertic.model.Entry;
import com.ivan.sertic.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepo;


    @Override
    public Entry getEntryByExternalId(UUID externalEntryId) {
        return entryRepo.findByExternalId(externalEntryId);
    }

    @Override
    public List<Entry> getAllEntries(UUID externalDiaryId) {
        return entryRepo.getByExternalId(externalDiaryId);
    }

    @Override
    public void update(UUID externalEntryId, Entry entry) {
        entryRepo.save(entry);
    }

    @Override
    public void deleteByExternalId(UUID externalDiaryId) {
        entryRepo.deleteByExternalId(externalDiaryId);
    }

    @Override
    public void create(Entry entry) {
        entryRepo.save(entry);
    }
}
