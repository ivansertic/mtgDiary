package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Diary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface DiaryRepository extends CrudRepository<Diary, Long> {

    Diary findByExternalId(UUID externalID);

    @Query("Select d from Diary where d.user.externalUserId=?1")
    List<Diary> getByExternalId(UUID externalId);

    @Query("DELETE FROM Diary d where d.user.externalUserId =?1")
    void deleteAllDiariesFromUser(UUID externalUserId);

    @Query("DELETE FROM Diary d where d.user.externalUserId =?1 and d.externalDiaryId = ?2 ")
    void deleteDiaryFromUser(UUID externalUserId, UUID externalDiaryId);

    @Query("SELECT d from Diary where d.externalDiaryId = ?1 and d.user.externalUserId=?2")
    Diary getDiaryByUser(UUID externalDiaryId, UUID externalUserId);
}
