package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CardRepository extends CrudRepository<Card, Long> {
    Card findByExternalId(UUID externalId);
}
