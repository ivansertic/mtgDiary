package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Diary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiaryRepository extends CrudRepository<Diary, Long> {

    Diary findByExternalDiaryId(UUID externalID);

    @Query("Select d from Diary d where d.user.externalUserId=?1")
    List<Diary> getByExternalId(UUID externalId);

    @Modifying
    @Query("DELETE FROM Diary d where d.user.externalUserId =?1")
    void deleteAllDiariesFromUser(UUID externalUserId);

    @Modifying
    @Query("DELETE FROM Diary d where d.user.externalUserId = ?1 and d.externalDiaryId = ?2 ")
    void deleteDiaryFromUser(UUID externalUserId, UUID externalDiaryId);

    @Modifying
    @Query("DELETE FROM Diary d where  d.externalDiaryId = ?1 ")
    void deleteDiary(UUID externalDiaryId);

    @Query("SELECT d from Diary d where d.externalDiaryId = ?1 and d.user.externalUserId=?2")
    Diary getDiaryByUser(UUID externalDiaryId, UUID externalUserId);
}
