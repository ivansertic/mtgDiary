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

    @Query("DELETE FROM Card c Where c.cardExternalId = ?1")
    void deleteByExternalCardId(UUID externalCardId);
}
