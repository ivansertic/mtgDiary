package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Library;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface LibraryRepository extends CrudRepository<Library, Long> {

    Library findByExternalId(UUID externalId);

    @Query("Select l From Library where l.user.externalUserId = ?1")
    List<Library> getByExternalId(UUID externalId);

    @Query("DELETE FROM Library l where l.user.externalUserId= ?1")
    void deleteByExternalId(UUID externalUserId);
}
