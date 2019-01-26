package com.ivan.sertic.controllers;

import com.ivan.sertic.dto.UserDto;
import com.ivan.sertic.model.Users;
import com.ivan.sertic.services.UserService;
import com.ivan.sertic.util.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class RestLoginController {
    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<Map<String,String>> logIn(@Valid @RequestBody UserDto dto){
        try {
            Users user = userService.getUserByUsernameAndPassword(dto.getUsername(), Md5Hash.hashPassword(dto.getPassword()));
            return ResponseEntity.ok().body(Map.of("token", user.getExternalId().toString()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error","Hashing went wrong"));
        }
    }
}
