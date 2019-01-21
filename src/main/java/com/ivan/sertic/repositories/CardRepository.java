package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends CrudRepository<Card, Long> {
    /* Ako ovo odkomentiram reče mi da funkcija findByExternalId vec postoji*/
    //Card findByExternalId(UUID externalId);


    @Query("SELECT c FROM Card WHERE c.library.externaLibraryId = ?1")
    List<Card> findByExternalId(UUID externalId);
}
