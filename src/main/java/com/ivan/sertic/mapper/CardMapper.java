package com.ivan.sertic.mapper;

import com.ivan.sertic.dto.CardDto;
import com.ivan.sertic.model.Card;

public class CardMapper {

    public void update(Card entity, CardDto dto){
        entity.setDescription(dto.getDescription());
        entity.setEdition(dto.getEdition());
        entity.setManaCost(dto.getManaCost());
        entity.setName(dto.getName());
    }

    public CardDto cardDto(Card entity){
        CardDto dto = new CardDto();
        dto.setDescription(entity.getDescription());
        dto.setEdition(entity.getEdition());
        dto.setManaCost(entity.getManaCost());
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        dto.setExternalCardId(entity.getExternalId());

        return dto;
    }

    public Card createEntity(CardDto dto){
        Card entity = new Card();
        update(entity, dto);
        return entity;
    }


}
