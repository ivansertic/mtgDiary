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

    @Query("DELETE FROM Entry e where e.diary.externalDiaryId=?1")
    void deleteByExternalId(UUID externalUserId);

    @Query("SELECT e FROM Entry where e.diar.externalDiaryId=?1 and e.diary.user.externalUserId = ?2 and e.externalEntryId =?3")
    Entry getByUserAndDiary(UUID externalDiaryId, UUID externalUserId, UUID externalEntryId);
}
