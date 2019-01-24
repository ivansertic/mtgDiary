package com.ivan.sertic.services;

import com.ivan.sertic.model.Diary;

import java.util.List;
import java.util.UUID;

public interface DiaryService {

    Diary getDiaryByExternalId(UUID externalDiaryId);

    List<Diary> getAllDiaries();

    void update(UUID externalDiaryId,Diary diary);

    void deleteByExternalId(UUID externalDiaryId);

    void create(Diary diary);
}
