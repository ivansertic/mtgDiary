package com.ivan.sertic.services;

import com.ivan.sertic.model.Diary;
import com.ivan.sertic.repositories.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepo;

    @Override
    public Diary getDiaryByExternalId(UUID externalDiaryId) {
        return diaryRepo.findByExternalId(externalDiaryId);
    }

    @Override
    public List<Diary> getAllDiaries(UUID externalUserId) {
        return diaryRepo.getByExternalId(externalUserId);
    }

    @Override
    public void update(UUID externalDiaryId, Diary diary) {
        diaryRepo.save(diary);
    }

    @Override
    public void deleteAll(UUID externalUserId) {
        diaryRepo.deleteAllDiariesFromUser(externalUserId);
    }

    @Override
    public void delete(UUID externalUserId, UUID externalDiaryId) {
        diaryRepo.deleteDiaryFromUser(externalUserId,externalDiaryId );
    }

    @Override
    public void create(Diary diary) {
        diaryRepo.save(diary);
    }

    @Override
    public Diary getDiaryFromUser(UUID externalDiaryId, UUID externalUserId) {
        return diaryRepo.getDiaryByUser(externalDiaryId,externalUserId);
    }
}
