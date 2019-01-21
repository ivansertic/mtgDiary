package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Entry;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EntryRepository extends CrudRepository<Entry, Long> {
    Entry findByExternalId(UUID externalId);
}
