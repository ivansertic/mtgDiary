package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    Card findByExternalCardId(UUID externalId);


    @Query("SELECT c FROM Card c WHERE c.library.externalLibraryId = ?1")
    List<Card> getByExternalId(UUID externalId);

    @Modifying
    @Query("DELETE FROM Card c Where c.externalCardId = ?1")
    void deleteByExternalCardId(UUID externalCardId);

    @Query("SELECT c FROM Card c WHERE c.library.externalLibraryId =?1 AND c.library.user.externalUserId = ?2 AND c.externalCardId = ?3")
    Card getCardByUserAndLibraryId(UUID externalLibraryId, UUID externalUserId, UUID externalCardId);
}
