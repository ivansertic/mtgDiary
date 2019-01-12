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
public class RestEntryController {


    public static final Logger logger = LoggerFactory.getLogger(RestDiaryController.class);

    //Returns entry of a diary

    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry/{externalEntryId}", method = RequestMethod.GET)
    public ResponseEntity<String> getDiaryEntry(@PathVariable("externalUserId") UUID externalUserId,
                                                @PathVariable("externalDiaryId") UUID externalDiaryId,
                                                @PathVariable("externalEntryId") UUID externalEntryId){
        return new ResponseEntity<String>("Here's your entry", HttpStatus.OK);
    }

    //Create Diary entry

    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry", method = RequestMethod.POST)
    public ResponseEntity<String> createDiaryEntry(@PathVariable("externalUserId") UUID externalUserId,
                                                   @PathVariable("externalDiaryId") UUID externalDiaryId){
        return new ResponseEntity<String>("I've made this for U", HttpStatus.OK);
    }

    //Update Diary

    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry/{externalEntryId}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEntry(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalDiaryId")UUID externalDiaryId,
                                              @PathVariable("externalEntryId")UUID externalEntryId){
        return new ResponseEntity<String>("Your entry has been updated", HttpStatus.OK);
    }

    //Delete entry

    @RequestMapping(value = "/{externalUserId}/diary/{externalDiaryId}/entry/{externalEntryId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEntry(@PathVariable("externalUserId")UUID externalUserId,
                                              @PathVariable("externalDiaryId")UUID externalDiaryId,
                                              @PathVariable("externalEntryId")UUID externalEntryId){
        return new ResponseEntity<String>("Your entry has been deleted", HttpStatus.OK);
    }
}
