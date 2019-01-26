package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends CrudRepository<Card, Long> {

    Card findByExternalId(UUID externalId);


    @Query("SELECT c FROM Card WHERE c.library.externaLibraryId = ?1")
    List<Card> getByExternalId(UUID externalId);

    @Query("DELETE FROM Card c Where c.library.externalLibraryId = ?1")
    void deleteByExternalCardId(UUID externalCardId);

    @Query("SELECT c FROM Card WHERE c.library.externalLibraryId =?1 AND c.library.user.externalUserId = ?2 AND c.externalCardId = ?3")
    Card getCardByUserAndLibraryId(UUID externalLibraryId, UUID externalUserId, UUID externalCardId);
}
