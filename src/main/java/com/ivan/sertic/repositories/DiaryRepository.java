package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Diary;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DiaryRepository extends CrudRepository<Diary, Long> {
    Diary findByExternalId(UUID externalID);
}
