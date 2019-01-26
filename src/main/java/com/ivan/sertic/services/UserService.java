package com.ivan.sertic.services;

import com.ivan.sertic.model.Users;

import java.util.UUID;

public interface UserService {
    Users getUserByExternalId(UUID externalUserId);
}
