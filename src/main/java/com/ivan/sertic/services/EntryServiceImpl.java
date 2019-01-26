package com.ivan.sertic.services;

import com.ivan.sertic.model.Entry;
import com.ivan.sertic.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepo;


    @Override
    public Entry getEntryByExternalId(UUID externalEntryId) {
        return entryRepo.findByExternalId(externalEntryId);
    }

    @Override
    public Entry getSingleEntry(UUID externalDiaryId, UUID externalUserId,UUID externalEntryId) {
        return getSingleEntry(externalDiaryId,externalUserId, externalEntryId);
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
