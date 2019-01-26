package com.ivan.sertic.services;

import com.ivan.sertic.model.Diary;

import java.util.List;
import java.util.UUID;

public interface DiaryService {

    Diary getDiaryByExternalId(UUID externalDiaryId);

    List<Diary> getAllDiaries(UUID externalUserId);

    void update(UUID externalDiaryId,Diary diary);

    void deleteAll(UUID externalUserId);

    void delete(UUID externalUserId, UUID externalDiaryId);

    void create(Diary diary);

    Diary getDiaryFromUser(UUID externalDiaryId, UUID externalUserId);
}
