package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface EntryRepository extends CrudRepository<Entry, Long> {

    Entry findByExternalId(UUID externalId);

    @Query("Select e From Entry where e.diary.externalDiaryId= ?1")
    List<Entry> getByExternalId(UUID externalId);
}
