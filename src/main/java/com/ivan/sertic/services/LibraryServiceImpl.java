package com.ivan.sertic.services;

import com.ivan.sertic.model.Library;
import com.ivan.sertic.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepo;


    @Override
    public Library getByExternalId(UUID externalLibraryId) {
        return libraryRepo.findByExternalLibraryId(externalLibraryId);
    }

    @Override
    public List<Library> getAllLibraries(UUID externalUserId) {
        return libraryRepo.getAllByExternalId(externalUserId);
    }

    @Override
    public Library getLibraryFromUser(UUID externalUserId, UUID externalLibraryId) {
        return libraryRepo.getByExternalId(externalUserId, externalLibraryId);

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
