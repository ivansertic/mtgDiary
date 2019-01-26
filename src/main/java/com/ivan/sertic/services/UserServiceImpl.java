package com.ivan.sertic.services;

import com.ivan.sertic.model.User;
import com.ivan.sertic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByExternalId(UUID externalUserId) {
        return userRepository.findByExternalId(externalUserId);
    }
}
