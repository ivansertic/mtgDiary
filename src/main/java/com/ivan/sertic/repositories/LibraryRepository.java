package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Library;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LibraryRepository extends CrudRepository<Library, Long> {
    Library findByExternalId(UUID externalId);
}
