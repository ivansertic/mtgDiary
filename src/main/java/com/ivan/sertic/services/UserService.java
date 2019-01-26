package com.ivan.sertic.services;

import com.ivan.sertic.model.Users;

import java.util.UUID;

public interface UserService {
    Users getUserByExternalId(UUID externalUserId);

    Users getUserByUsernameAndPassword(String username, String password);

    void createUser(Users user);

}
