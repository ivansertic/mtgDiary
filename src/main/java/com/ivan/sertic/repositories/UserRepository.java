package com.ivan.sertic.repositories;

import com.ivan.sertic.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByExternalUserId(UUID externalId);
}
