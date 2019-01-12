package com.ivan.sertic.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RestRegisterController {
    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> register(){
        return new ResponseEntity<String>("You have beend registered", HttpStatus.OK);
    }
}
