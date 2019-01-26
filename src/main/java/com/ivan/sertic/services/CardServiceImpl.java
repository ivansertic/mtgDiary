package com.ivan.sertic.services;

import com.ivan.sertic.model.Card;
import com.ivan.sertic.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepo;

    @Override
    public Card getCardByExternalId(UUID externalCardId) {
        return cardRepo.findByExternalId(externalCardId);
    }

    @Override
    public List<Card> getAllCards(UUID libraryExternalId) {
        return cardRepo.getByExternalId(libraryExternalId);
    }

    @Override
    public Card getCardFromUserAndLibrary(UUID externalLibraryId, UUID externalUserId, UUID externalCardId) {
        return cardRepo.getCardByUserAndLibraryId(externalLibraryId, externalUserId, externalCardId);
    }

    @Override
    public void update(UUID externalCardId, Card card) {
        cardRepo.save(card);
    }

    @Override
    public void deleteByExternalId(UUID cardExternalId) {
        cardRepo.deleteByExternalCardId(cardExternalId);
    }

    @Override
    public void create(Card card) {
        cardRepo.save(card);
    }
}
