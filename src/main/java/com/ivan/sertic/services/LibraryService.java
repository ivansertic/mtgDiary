package com.ivan.sertic.services;

import com.ivan.sertic.model.Library;

import java.util.List;
import java.util.UUID;

public interface LibraryService {

    Library getByExternalId(UUID externalLibraryId);

    List<Library> getAllLibraries(UUID externalUserId);

    void update(UUID externalLibraryId,Library library);

    void deleteByExternalId(UUID externalUserId);

    void create(Library library);
}
