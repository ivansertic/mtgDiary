package com.ivan.sertic.services;

import com.ivan.sertic.model.Users;
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
    public Users getUserByExternalId(UUID externalUserId) {
        return userRepository.findByExternalUserId(externalUserId);
    }

    @Override
    public Users getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public void createUser(Users user) {
        userRepository.save(user);
    }
}
