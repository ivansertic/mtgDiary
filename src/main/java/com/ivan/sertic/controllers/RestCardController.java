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
public class RestCardController {

    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    //Return Cards of a library
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card", method = RequestMethod.GET)
    public ResponseEntity<String> getAllCards(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalLibraryId")UUID externalLibraryId){
        return new ResponseEntity<String>("These are your cards", HttpStatus.OK);
    }

    //Create Card
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card/{externalCardId}", method = RequestMethod.POST)
    public ResponseEntity<String> createCard(@PathVariable("externalUserId")UUID externalUserId,
                                             @PathVariable("externalLibraryId")UUID externalLibraryId,
                                             @PathVariable("externalCardId")UUID externalCardId){
        return new ResponseEntity<String>("Your spell has been crafted",HttpStatus.OK);
    }

    //Put a card into a library
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card/{externalCardId}", method = RequestMethod.PUT)
    public ResponseEntity<String> putCard(@PathVariable("externalUserId")UUID externalUserId,
                                          @PathVariable("externalLibraryId")UUID externalLibraryId,
                                          @PathVariable("externalCardId")UUID externalCardId){
        return new ResponseEntity<String>("Spell has been added",HttpStatus.OK);
    }

    //Delete Card
    @RequestMapping(value = "/{externalUserId}/library/{externalLibraryId}/card/{externalCardId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCard(@PathVariable("externalUserId")UUID externalUserId,
                                          @PathVariable("externalLibraryId")UUID externalLibraryId,
                                          @PathVariable("externalCardId")UUID externalCardId){
        return new ResponseEntity<String>("Spell has been removed",HttpStatus.OK);
    }
}
