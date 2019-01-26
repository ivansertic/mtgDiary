package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Entry;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {

    Entry findByExternalEntryId(UUID externalId);

    @Query("Select e From Entry e where e.diary.externalDiaryId= ?1")
    List<Entry> getByExternalDiaryId(UUID externalId);

    @Modifying
    @Query("DELETE FROM Entry e where e.diary.externalDiaryId=?1")
    void deleteByExternalDiaryId(UUID externalUserId);

    @Modifying
    @Query("DELETE FROM Entry e where e.externalEntryId=?1")
    void deleteByExternalId(UUID externalUserId);

    @Query("SELECT e FROM Entry e where e.diary.externalDiaryId=?1 and e.diary.user.externalUserId = ?2 and e.externalEntryId =?3")
    Entry getByUserAndDiary(UUID externalDiaryId, UUID externalUserId, UUID externalEntryId);
}
