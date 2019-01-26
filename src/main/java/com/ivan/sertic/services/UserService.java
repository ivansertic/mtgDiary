package com.ivan.sertic.services;

import com.ivan.sertic.model.User;

import java.util.UUID;

public interface UserService {
    User getUserByExternalId(UUID externalUserId);
}
