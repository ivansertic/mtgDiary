package com.ivan.sertic.services;

import com.ivan.sertic.model.Card;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardServiceImpl implements CardService {

    private static Map<UUID, Card> cardRepo = new HashMap<>();
    @Override
    public Card getCardByExternalId(UUID externalCardId) {
        return cardRepo.get(externalCardId);
    }

    @Override
    public Collection<Card> getAllCards() {
        return cardRepo.values();
    }

    @Override
    public void update(UUID externalCardId, Card card) {
        cardRepo.remove(externalCardId);
        card.setExternalId(externalCardId);
        cardRepo.put(externalCardId,card);
    }

    @Override
    public void deleteByExternalId(UUID cardExternalId) {
        cardRepo.remove(cardExternalId);
    }

    @Override
    public void create(Card card) {
        cardRepo.put(card.getExternalId(), card);
    }
}
