package com.ivan.sertic.services;

import com.ivan.sertic.model.Library;

import java.util.List;
import java.util.UUID;

public interface LibraryService {

    Library getByExternalId(UUID externalLibraryId);

    List<Library> getAllLibraries();

    void update(Library library);

    void deleteByExternalId(UUID externalLibraryId);

    void create(Library library);
}
