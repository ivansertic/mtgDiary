package com.ivan.sertic.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class RestLoginController {
    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity<String> logIn(){
        return new ResponseEntity<String>("You're logged in", HttpStatus.OK);
    }
}
