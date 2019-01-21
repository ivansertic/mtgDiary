package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Diary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface DiaryRepository extends CrudRepository<Diary, Long> {
    /* Ako ovo odkomentiram reče mi da funkcija findByExternalId vec postoji*/
    //Diary findByExternalId(UUID externalID);
    @Query("Select d from Diary where d.user.externalUserId=?1")
    List<Diary> findByExternalId(UUID externalId);
}
