package com.ivan.sertic.services;

import com.ivan.sertic.model.Card;

import java.util.List;
import java.util.UUID;

public interface CardService {

    Card getCardByExternalId(UUID externalCardId);

    List<Card> getAllCards(UUID libraryExternalId);

    Card getCardFromUserAndLibrary(UUID externalLibraryId, UUID externalUserId, UUID externalCardId);

    void update(UUID externalCardId,Card card);

    void deleteByExternalId(UUID cardExternalId);

    void create(Card card);
}
