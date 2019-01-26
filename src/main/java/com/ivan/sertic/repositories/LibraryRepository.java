package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Library;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Long> {

    Library findByExternalLibraryId(UUID externalId);

    @Query("Select l From Library l where l.user.externalUserId = ?1")
    List<Library> getAllByExternalId(UUID externalId);

    @Query("Select l From Library l where l.user.externalUserId = ?1 and l.externalLibraryId = ?2")
    Library getByExternalId(UUID externalId, UUID libraryId);

    @Modifying
    @Query("DELETE FROM Library l where l.externalLibraryId = ?1")
    void deleteByExternalId(UUID externalUserId);

}
