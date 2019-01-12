package com.ivan.sertic.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class RestLibraryController {

    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    //Retrieve all libraries
    @RequestMapping(value = "/{externalUserId}/library", method = RequestMethod.GET)
    public ResponseEntity<String> getAllLibraries(@PathVariable("externalUserId") UUID externalUserId){
        return new ResponseEntity<String>("Your library is well done, dark one", HttpStatus.OK);
    }

    //Retrieve one Library
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}", method = RequestMethod.GET)
    public ResponseEntity<String> getOneLibrary(@PathVariable("externalUserId")UUID externalUserId,
                                                @PathVariable("externalLibraryId")UUID externalLibraryId){
        return new ResponseEntity<String>("This is one library", HttpStatus.OK);
    }

    //Create library
    @RequestMapping(value = "/{externalUserId}/library", method = RequestMethod.POST)
    public ResponseEntity<String> createLibrary(@PathVariable("externalUserId")UUID externalUserId){
        return new ResponseEntity<String>("Your library has been created",HttpStatus.OK);
    }

    //Delete library
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteLibrary(@PathVariable("externalUserId")UUID externalUserId,
                                                @PathVariable("externalLibraryId") UUID externalLibraryId){
        return new ResponseEntity<String>("I've deleted your library",HttpStatus.OK);
    }

    //Delete All Libraries
    @RequestMapping(value = "/{externalUserId}/library", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAllLibraries(@PathVariable("externalUserId") UUID externalUserId){
        return new ResponseEntity<String>("Everything burnt to the ground",HttpStatus.OK);
    }
}
