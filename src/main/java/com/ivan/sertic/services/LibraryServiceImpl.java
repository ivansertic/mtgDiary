package com.ivan.sertic.services;

import com.ivan.sertic.model.Library;
import com.ivan.sertic.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepo;


    @Override
    public Library getByExternalId(UUID externalLibraryId) {
        return libraryRepo.findByExternalId(externalLibraryId);
    }

    @Override
    public List<Library> getAllLibraries(UUID externalUserId) {
        return libraryRepo.getByExternalId(externalUserId);
    }

    @Override
    public void update(UUID externalLibraryId, Library library) {
        libraryRepo.save(library);
    }

    @Override
    public void deleteByExternalId(UUID externalUserId) {
        libraryRepo.deleteByExternalId(externalUserId);
    }

    @Override
    public void create(Library library) {
        libraryRepo.save(library);
    }
}
